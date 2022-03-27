package com.github.geemu.generate.entity;

import lombok.Data;

import java.util.List;

/**
 * 数据库
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-27 19:56:38
 */
@Data
public class Cat {

    /** 表目录名 **/
    private String name;
    /** 数据表 **/
    private List<Table> tables;

}
