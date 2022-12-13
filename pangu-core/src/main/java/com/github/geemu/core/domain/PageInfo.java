package com.github.geemu.core.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * PageInfo
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-12-24 22:47:01
 */
@Data
@SuperBuilder
public class PageInfo<T> {

    /** 总页码数 **/
    private Long total;
    /** 当前页码 **/
    private Long current;
    /** 上一页 **/
    private Long pre;
    /** 下一页 **/
    private Long next;
    /** 当前页面数据 **/
    private List<T> data;

}
