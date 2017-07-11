package com.zark.easyframe.biz.common;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zark.easyframe.common.module.UserDo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public static void main(String[] args) {
		String a = "{username:123}";
		UserDo userDo = JSONObject.parseObject(a, UserDo.class);
		System.out.println(userDo);

		String b = "[{username:1234},{username:12345}]";
		List<UserDo> userDos = JSONArray.parseArray(b, UserDo.class);
		System.out.println(userDos);
	}
}
