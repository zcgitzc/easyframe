package com.zark.easyframe.conf.mapper;

import com.zark.easyframe.conf.module.WebPageInfoDo;
import com.zark.easyframe.conf.module.WebPageInfoDoExample;
import java.util.List;

public interface WebPageInfoDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(WebPageInfoDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(WebPageInfoDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(WebPageInfoDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<WebPageInfoDo> selectByExampleWithBLOBs(WebPageInfoDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<WebPageInfoDo> selectByExample(WebPageInfoDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    WebPageInfoDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(WebPageInfoDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeyWithBLOBs(WebPageInfoDo record);
}