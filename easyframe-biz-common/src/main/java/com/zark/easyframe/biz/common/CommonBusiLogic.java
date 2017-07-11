package com.zark.easyframe.biz.common;

import com.zark.easyframe.common.vo.Page;

/**
 * 
 */
public class CommonBusiLogic {
	/**
	 * 初始化Page的Begin和End
	 * 
	 * @param page
	 * @return
	 */
	public static Page setPageBeginByPage(Page page) {
		if (page != null) {
			page.setBegin(((page.getCurrent() - 1) * page.getLength()));
			page.setEnd(page.getBegin() + page.getLength());
		}
		return page;
	}

	public static String subStringByLength(String oriString, int length) {
		if (null != oriString && oriString.getBytes().length > length) {
			return oriString.substring(0, length / 3);
		}
		return oriString;
	}

}
