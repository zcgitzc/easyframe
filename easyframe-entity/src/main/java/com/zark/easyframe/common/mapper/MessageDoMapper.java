package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.MessageDo;
import com.zark.easyframe.common.module.MessageDoExample;
import java.util.List;

public interface MessageDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(MessageDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(MessageDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(MessageDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<MessageDo> selectByExample(MessageDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    MessageDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(MessageDo record);
}