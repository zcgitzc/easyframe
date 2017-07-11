package com.zark.easyframe.biz.common.bo.impl;

import javax.annotation.Resource;

import com.zark.easyframe.biz.common.bo.LockBo;
import com.zark.easyframe.common.mapper.LockDoMapperExt;
import com.zark.easyframe.common.module.LockDo;

public class LockBoImpl implements LockBo {

    @Resource
    private LockDoMapperExt locksDoMapperExt;

    @Override
    public void lock(String type, String value) {

        LockDo locksDo = locksDoMapperExt.getLock(type, value);
        if(locksDo == null){
            doCreateLock(type, value);
        }
    }

    private LockDo doCreateLock(String type, String value){
        LockDo locksDo = new LockDo();
        locksDo.setType(type);
        locksDo.setValue(value);
        locksDoMapperExt.insertSelective(locksDo);
        return locksDo;
    }

}
