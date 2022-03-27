package com.github.geemu.generate.entity;

import com.github.geemu.generate.JdbcType;
import lombok.Data;

/**
 * 表字段信息
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-22 20:47:56
 */
@Data
public class Column {

    /** 字段名称 **/
    private String name;
    /** 字段类型 **/
    private JdbcType jdbcType;
    /** 字段大小 **/
    private int size;
    /** 字段精度 **/
    private int scale;
    /** 字段注释 **/
    private String comment;
    /** 是否可空 **/
    private Boolean nullable;
    /** 默认值 **/
    private String defaultValue;
    /** 排序 **/
    private Integer sort;

}
