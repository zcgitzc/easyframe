package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.MessageReceiverDo;
import com.zark.easyframe.common.module.MessageReceiverDoExample;
import java.util.List;

public interface MessageReceiverDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(MessageReceiverDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(MessageReceiverDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(MessageReceiverDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<MessageReceiverDo> selectByExample(MessageReceiverDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    MessageReceiverDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(MessageReceiverDo record);
}