package com.zark.easyframe.common.util.jsoup.entity;

import java.util.List;

/**
 * 
 * @author wb-zc189961
 *
 */
public class WebPageInfo {
	private String title;
	private String url;
	private String host;
	private String ip;
	private String content;
	private String styles;
	private List<String> links;
	private String scripts;

	public WebPageInfo() {
		super();
	}

	public WebPageInfo(String title, String url, String host, String ip, String content) {
		super();
		this.title = title;
		this.url = url;
		this.host = host;
		this.ip = ip;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStyles() {
		return styles;
	}

	public void setStyles(String styles) {
		this.styles = styles;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

	public String getScripts() {
		return scripts;
	}

	public void setScripts(String scripts) {
		this.scripts = scripts;
	}
}
