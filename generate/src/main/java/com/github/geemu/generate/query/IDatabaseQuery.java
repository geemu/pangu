package com.github.geemu.generate.query;

import java.util.List;
import java.util.Map;

/**
 * 数据源查询接口
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 21:09:57
 */
public interface IDatabaseQuery {

    /**
     * 获取所有名称
     * @return String
     */
    List<String> names();

    /**
     * 获取所有注释
     * @return Map<String, String>
     */
    Map<String,String> comments();

    /**
     * 获取指定名称
     * @return String
     */
    String name();

    /**
     * 获取指定注释
     * @return String
     */
    String comment();

}
