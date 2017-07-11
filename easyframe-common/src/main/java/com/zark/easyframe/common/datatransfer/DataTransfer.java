package com.zark.easyframe.common.datatransfer;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public interface DataTransfer {

    void transfer(Object value);

    void transfer(Collection<?> values);

    void transfer(Class<?> clazz, Collection<?> values);
}
