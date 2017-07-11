package com.zark.easyframe.common.util.collection;

import java.util.*;


/**
 * Created by qiuzhen on 16/3/27.
 */
public class MapUtils {

    /**
     * 将一个迭代器转换为一个map
     * <p>
     * value就是迭代器的自身元素
     * <p>
     * key由mapKeyProvidor指定
     *
     * @param iterator       迭代器
     * @param mapKeyProvidor map的key的提供者
     * @return Map<K, V>
     */
    public static <K, V> Map<K, V> getMap(Iterator<V> iterator, MapKeyProvidor<K, V> mapKeyProvidor) {
        Map<K, V> map = new HashMap<K, V>();
        while (iterator.hasNext()) {
            V v = iterator.next();
            K key = mapKeyProvidor.getKey(v);
            if(key != null){
                map.put(key, v);
            }
        }
        return map;
    }

    /**
     * 将一个迭代器转换为一个map
     * <p>
     * value就是迭代器的自身元素
     * <p>
     * key由mapKeyProvidor指定
     *
     * @param iterator       迭代器
     * @param mapKeyProvidor map的key的提供者
     * @return Map<K, List<V>>
     */
    public static <K, V> Map<K, List<V>> getListMap(Iterator<V> iterator, MapKeyProvidor<K, V> mapKeyProvidor) {
        Map<K, List<V>> map = new HashMap<K, List<V>>();
        while (iterator.hasNext()) {
            V v = iterator.next();
            K key = mapKeyProvidor.getKey(v);

            if(key == null){
                continue;
            }

            List<V> value = map.get(key);
            if(value == null){
                value = new ArrayList<V>();
                map.put(key, value);
            }
            value.add(v);
        }
        return map;
    }

    /**
     * 将一个迭代器转换为一个map
     * <p>
     * value就是迭代器的自身元素
     * <p>
     * key由mapKeyProvidor指定
     *
     * @param iterator       迭代器
     * @param mapKeyProvidor map的key的提供者
     * @return Map<K, Set<V>>
     */
    public static <K, V> Map<K, Set<V>> getSetMap(Iterator<V> iterator, MapKeyProvidor<K, V> mapKeyProvidor) {
        Map<K, Set<V>> map = new HashMap<K, Set<V>>();
        while (iterator.hasNext()) {
            V v = iterator.next();
            K key = mapKeyProvidor.getKey(v);

            if(key == null){
                continue;
            }

            Set<V> value = map.get(key);
            if(value == null){
                value = new HashSet<V>();
                map.put(key, value);
            }
            value.add(v);
        }
        return map;
    }
}


