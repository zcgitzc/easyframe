package com.zark.easyframe.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeloctiyTemplateUtil {

	private static Logger log = LoggerFactory.getLogger(VeloctiyTemplateUtil.class);

	private static final String VELOCITY_PROPERTIES = "/velocity.properties";
	public static final String DEFAULT_FILE_ENCODE = "UTF-8";
	private static VelocityEngine ve;

	static {
		log.info("Begin to init veloctiy engine");
		ve = new VelocityEngine();
		// pdf导出，发送邮件可以用velocity
		Properties properties = new Properties();
		// 读取资源文件的方式
		InputStream in = null;
		try {
			in = VeloctiyTemplateUtil.class.getResourceAsStream(VELOCITY_PROPERTIES);
			if (in == null) {
				throw new IOException();
			}
			properties.load(in);
			System.out.println(properties.get("Velocity.ENCODING_DEFAULT"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error("Close velocityProperties inputStream ", e);
				}
			}
		}
		ve.init(properties);
		log.info("Init veloctiy engine success");
	}

	public static String getContent(String fileName, Map<String, Object> values) {
		Template template = ve.getTemplate(fileName, DEFAULT_FILE_ENCODE);
		if (values == null) {
			values = new HashMap<String, Object>();
		}
		VelocityContext context = getContext(values);
		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		return sw.toString();
	}

	private static VelocityContext getContext(Map<String, Object> values) {
		VelocityContext context = new VelocityContext();

		for (Map.Entry<String, Object> entry : values.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (key != null && value != null) {
				context.put(key, value);
			}
		}
		return context;
	}
}
