package com.zark.easyframe.common.util.collection;

import java.util.*;

/**
 * sql工具 Created by qiuzhen on 16/3/24.
 */
@SuppressWarnings("rawtypes")
public class SqlUtils {

    /**
     * 将迭代器元素中的特定字段值,按照1000为一组值,分批组装到list集合中 每1000个值放在一个set中(oracle in语句的值不能超过1000个)
     * 
     * @param tIterator 通用业集合迭代器
     * @param sqlInValueProvider 获取元素的字段值
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T, V> List<Set> getSqlInList(Iterator<T> tIterator, SqlInValueProvider<T, V> sqlInValueProvider) {
		List<Set> setList = new ArrayList<Set>();

        int i = 0;
        Set set = new HashSet();
        while (tIterator.hasNext()) {
            if (i % 1000 == 0) {
                set = new HashSet();
                setList.add(set);
            }
            T t = tIterator.next();

            if (t == null) {
                continue;
            }

            V v = sqlInValueProvider.getInValue(t);
            if (v != null) {
                set.add(v);
            }
            i++;
        }
        return setList;
    }

    /**
     * 根据给定迭代器, 组装key列表
     * 
     * @param tIterator 迭代器
     * @param sqlInValueProvider key提供者
     * @param <T> 迭代器元素
     * @param <V> key类型
     * @return key列表
     */
    public static <T, V> Set<V> getKeySet(Iterator<T> tIterator, SqlInValueProvider<T, V> sqlInValueProvider) {
        Set<V> set = new HashSet<V>();
        while (tIterator.hasNext()) {
            T t = tIterator.next();

            if (t == null) {
                continue;
            }

            V v = sqlInValueProvider.getInValue(t);
            if (v != null) {
                set.add(v);
            }
        }
        return set;
    }

    /**
     * 根据给定迭代器, 组装key列表
     * 
     * @param tIterator 迭代器
     * @param sqlInValueProvider key提供者
     * @param <T> 迭代器元素
     * @param <V> key类型
     * @return key列表
     */
    public static <T, V> List<V> getKeyList(Iterator<T> tIterator, SqlInValueProvider<T, V> sqlInValueProvider) {
        List<V> arrayList = new ArrayList<V>();
        while (tIterator.hasNext()) {
            T t = tIterator.next();

            if (t == null) {
                continue;
            }

            V v = sqlInValueProvider.getInValue(t);
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }

    /**
     * 适用于已经拿到List<T>，需要转换成List<List<T>>的方式
     * 
     * @param items
     * @return
     */
    public static <T> List<List<T>> getSqlInList(Iterable<T> items , int divCount) {
        if (items == null) {
            return null;
        }
        List<List<T>> result = new ArrayList<List<T>>();
        int currentIndex = 0;
        for (T item : items) {
            if (currentIndex % divCount == 0) {
                result.add(new ArrayList<T>());
                currentIndex = 0;
            }
            result.get(result.size() - 1).add(item);
            currentIndex++;
        }
        return result;
    }
}
