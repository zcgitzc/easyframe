package com.zark.easyframe.biz.conf.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zark.easyframe.biz.conf.bo.WebPageInfoBo;
import com.zark.easyframe.conf.dto.WebPageInfoCondDto;
import com.zark.easyframe.conf.mapper.WebPageInfoDoMapperExt;
import com.zark.easyframe.conf.module.WebPageInfoDo;
import com.zark.easyframe.conf.module.WebPageInfoDoExample;

@Service
public class WebPageInfoBoImpl implements WebPageInfoBo {

	@Resource
	private WebPageInfoDoMapperExt webPageInfoDoMapperExt;

	@Override
	public List<WebPageInfoDo> queryAll(WebPageInfoCondDto condDto) {
		// TODO 条件查询以后再搞
		return webPageInfoDoMapperExt.selectByExample(new WebPageInfoDoExample());
	}

	@Override
	public WebPageInfoDo queryById(Long id) {
		return webPageInfoDoMapperExt.selectByPrimaryKey(id);
	}

	@Override
	public void add(WebPageInfoDo webPageInfoDo) {
		webPageInfoDoMapperExt.insertSelective(webPageInfoDo);
	}

}
