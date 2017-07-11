package com.zark.easyframe.common.mapper;

import com.zark.easyframe.common.module.FileDo;
import com.zark.easyframe.common.module.FileDoExample;
import java.util.List;

public interface FileDoMapper {
    /**
     *
     * @mbggenerated 2017-07-08
     */
    int countByExample(FileDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int deleteByPrimaryKey(FileDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int insertSelective(FileDo record);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    List<FileDo> selectByExample(FileDoExample example);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    FileDo selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-07-08
     */
    int updateByPrimaryKeySelective(FileDo record);
}