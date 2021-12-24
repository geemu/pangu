package com.github.geemu.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ListUtils
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-12-19 16:48:36
 */
public final class ListUtils {

    /**
     * 工具类隐藏构造
     */
    private ListUtils() {
        // ignore private construct
    }

    /**
     * 分桶
     * @param source source
     * @param size 每个桶的大小
     * @param <T> <T>的类型
     * @return List<List < T>>
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int size) {
        List<List<T>> response = new ArrayList<>();
        if (null == source || source.size() <= 0 || size <= 0) {
            return response;
        }
        int remainder = source.size() % size;
        int number = source.size() / size;
        int offset = 0;
        for (int i = 0; i < size; i++) {
            List<T> value;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            response.add(value);
        }
        return response;
    }

}
