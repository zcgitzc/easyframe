package com.zark.easyframe.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zark.easyframe.common.module.UserDo;
import com.zark.easyframe.common.vo.Page;
import com.zark.easyframe.common.vo.QueryUserCond;

@Repository
public interface UserDoMapperExt extends UserDoMapper {

	UserDo queryByUsername(@Param("username") String username);

	List<UserDo> queryByPage(@Param("page") Page page, @Param("cond") QueryUserCond queryUserCond);

	int countByPage(@Param("cond") QueryUserCond queryUserCond);
}