package com.zark.easyframe.common.datatransfer;

import java.util.List;
import java.util.Map;

public interface DataProvider<K, V> {

    String getType();

    Map<K, V> getTransferredData(List<K> dataList);
}
