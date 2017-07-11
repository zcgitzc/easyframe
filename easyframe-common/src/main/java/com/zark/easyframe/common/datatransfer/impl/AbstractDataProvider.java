package com.zark.easyframe.common.datatransfer.impl;

import com.zark.easyframe.common.datatransfer.DataProvider;

public abstract class AbstractDataProvider<K, V> implements DataProvider<K, V> {

    private String type;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
