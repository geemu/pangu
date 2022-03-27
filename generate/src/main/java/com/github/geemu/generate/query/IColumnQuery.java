package com.github.geemu.generate.query;

import java.util.List;
import java.util.Map;

/**
 * 表字段信息查询接口
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 21:09:57
 */
public interface IColumnQuery extends IDatabaseQuery {

    /**
     * 获取所有字段名称
     * @return String
     */
    @Override
    List<String> names();

    /**
     * 获取所有字段注释
     * @return Map<String, String>
     */
    @Override
    Map<String, String> comments();

    /**
     * 获取指定字段名称
     * @return String
     */
    @Override
    String name();

    /**
     * 获取指定字段注释
     * @return String
     */
    @Override
    String comment();

}
