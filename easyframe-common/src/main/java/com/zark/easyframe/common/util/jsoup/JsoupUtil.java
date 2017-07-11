package com.zark.easyframe.common.util.jsoup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zark.easyframe.common.util.jsoup.entity.SimpleCondition;
import com.zark.easyframe.common.util.jsoup.entity.WebPageInfo;

public class JsoupUtil {
	private static final Logger logger = LoggerFactory.getLogger(JsoupUtil.class);

	private static final List<Pair<String, String>> NEED_BASE_URL_TAGS = new ArrayList<Pair<String, String>>();

	private static final List<String> REMOVE_TAGS = new ArrayList<>();

	private static final Pair<String, String> LINK_PAIR = Pair.of("link", "href");
	private static final Pair<String, String> IMG_PAIR = Pair.of("img", "src");
	private static final Pair<String, String> A_PAIR = Pair.of("a", "href");

	private static final String HTTP_PREFIX = "http";
	private static final String LINK = "link";

	private static final String STYLE = "style";
	private static final String SCRIPT = "script";

	static {
		NEED_BASE_URL_TAGS.add(LINK_PAIR);
		NEED_BASE_URL_TAGS.add(IMG_PAIR);
		NEED_BASE_URL_TAGS.add(A_PAIR);

		REMOVE_TAGS.add(STYLE);
		REMOVE_TAGS.add(SCRIPT);
	}

	public static WebPageInfo parseUrl(String url, SimpleCondition condition) {
		return getDocument(url, condition);
	}

	private static WebPageInfo getDocument(String url, SimpleCondition condition) {
		Document doc;
		try {
			logger.debug("start parse url : " + url);
			doc = Jsoup.connect(url).timeout(5 * 60 * 1000).get();
			addBaseUrlIfNess(url, doc);
			// toFile(content);
			return buildWebPageInfo(url, doc, condition);
		} catch (IOException e) {
			logger.error("connect url:" + url + "fail.", e);
		}
		return null;
	}

	private static void toFile(String content) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File("D:/project/vue_study/myspringboot/myspringboot-web/src/main/webapp/webpage/index.html"));
			fileOutputStream.write(content.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String filterDocument(Document doc, SimpleCondition condition) {
		if (condition == null) {
			return doc.toString();
		}
		if (StringUtils.isEmpty(condition.getTagNameEq()) && StringUtils.isEmpty(condition.getClassNameEq()) && StringUtils.isEmpty(condition.getContainText()) && StringUtils.isEmpty(condition.getIdEq())) {
			return doc.toString();
		}
		Elements elements = null;

		if (StringUtils.isNotEmpty(condition.getTagNameEq())) {
			elements = doc.getElementsByTag(condition.getTagNameEq());
		}
		if (StringUtils.isNotEmpty(condition.getClassNameEq())) {
			elements = doc.getElementsByClass(condition.getClassNameEq());
		}
		if (StringUtils.isNotEmpty(condition.getContainText())) {
			elements = doc.getElementsContainingText(condition.getContainText());
		}
		if (StringUtils.isNotEmpty(condition.getIdEq())) {
			elements = new Elements();
			elements.add(doc.getElementById(condition.getIdEq()));
		}
		logger.debug("doc info:\n" + elements.toString());
		return elements.toString();
	}

	private static WebPageInfo buildWebPageInfo(String url, Document doc, SimpleCondition condition) {
		WebPageInfo webPageInfo = new WebPageInfo();
		Pair<String, String> hostAndIpPair = parseIpByUrl(url);
		if (hostAndIpPair != null) {
			webPageInfo.setHost(hostAndIpPair.getLeft());
			webPageInfo.setIp(hostAndIpPair.getRight());
		}
		webPageInfo.setTitle(doc.title());
		List<String> links = new ArrayList<String>();

		Elements linkEles = doc.getElementsByTag(LINK);
		for (Element link : linkEles) {
			if (link.attr("rel").equalsIgnoreCase("stylesheet")) {
				links.add(link.attr("href"));
			}
		}
		webPageInfo.setLinks(links);

		Elements styleEles = doc.getElementsByTag(STYLE);
		String styles = StringUtils.EMPTY;
		for (Element style : styleEles) {
			styles += style.data();
		}
		webPageInfo.setStyles(styles);
		webPageInfo.setUrl(url);

		for (String removeTag : REMOVE_TAGS) {
			Elements tags = doc.getElementsByTag(removeTag);
			for (Element tag : tags) {
				tag.remove();
			}
		}

		webPageInfo.setContent(filterDocument(doc, condition));
		return webPageInfo;
	}

	public static WebPageInfo parseUrl(String url) {
		return getDocument(url, null);
	}

	private static Pair<String, String> parseIpByUrl(String url) {
		url = url.substring(url.indexOf("//") + 2, url.indexOf("/", url.indexOf("//") + 2));
		InetAddress ip;
		try {
			ip = InetAddress.getByName(url);
			return Pair.of(ip.getHostName(), ip.getHostAddress());
		} catch (UnknownHostException e) {
			logger.error("parseIpByUrl error. url=" + url, e);
		}
		return null;
	}

	private static void addBaseUrlIfNess(String url, Document doc) {
		String baseUrl = url.substring(0, url.lastIndexOf("/") + 1);
		logger.debug("baseUrl:" + baseUrl);
		for (Pair<String, String> pair : NEED_BASE_URL_TAGS) {
			Elements eles = doc.getElementsByTag(pair.getLeft());
			for (Element element : eles) {
				String attrValue = element.attr(pair.getRight());
				if (!attrValue.startsWith(HTTP_PREFIX)) {
					if (attrValue.startsWith("//")) {
						element.attr(pair.getRight(), HTTP_PREFIX + ":" + attrValue);
					} else if (attrValue.startsWith("/")) {
						baseUrl = url.substring(url.indexOf("//") + 2, url.indexOf("/", url.indexOf("//") + 2));
						element.attr(pair.getRight(), HTTP_PREFIX + ":" + baseUrl + attrValue);
					} else {
						element.attr(pair.getRight(), baseUrl + attrValue);
					}
					logger.debug("<" + pair.getLeft() + "/> tag. attribute: '" + pair.getRight() + "' had be replaced. old:[" + attrValue + "],new:[" + element.attr(pair.getRight()) + "]");
				}

			}
		}
	}

	public static void main(String[] args) {
		WebPageInfo webPageInfo = parseUrl("http://www.runoob.com/try/try.php?filename=tryhtml5_style_scoped", new SimpleCondition("body", null, null, null));
		// WebPageInfo webPageInfo =
		// parseUrl("http://blog.csdn.net/lxhjh/article/details/51711148",
		// null);
		System.out.println(webPageInfo.getLinks());
		System.out.println(webPageInfo.getStyles());
	}
}
