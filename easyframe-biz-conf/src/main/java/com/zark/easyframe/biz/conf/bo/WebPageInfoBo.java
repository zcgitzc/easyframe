package com.zark.easyframe.biz.conf.bo;

import java.util.List;

import com.zark.easyframe.conf.dto.WebPageInfoCondDto;
import com.zark.easyframe.conf.module.WebPageInfoDo;


public interface WebPageInfoBo {

	List<WebPageInfoDo> queryAll(WebPageInfoCondDto condDto);

	WebPageInfoDo queryById(Long id);

	void add(WebPageInfoDo webPageInfoDo);

}
