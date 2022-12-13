package com.github.geemu.generate.entity;

import lombok.Data;

import java.util.List;

/**
 * 表信息
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 20:47:56
 */
@Data
public class Table {

    /** 表名称 **/
    private String name;
    /** 表注释 **/
    private String comment;
    /** 字段信息 **/
    private List<Column> columns;

}
