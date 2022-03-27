package com.github.geemu.generate.query;

import java.util.List;
import java.util.Map;

/**
 * 表信息查询接口
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 21:09:57
 */
public interface ITableQuery extends IDatabaseQuery {

    /**
     * 获取所有表名称
     * @return String
     */
    @Override
    List<String> names();

    /**
     * 获取所有表注释
     * @return Map<String, String>
     */
    @Override
    Map<String, String> comments();

    /**
     * 获取指定表名称
     * @return String
     */
    @Override
    String name();

    /**
     * 获取指定表注释
     * @return String
     */
    @Override
    String comment();

}
