package com.github.geemu.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * PageEntity
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-12-24 22:47:01
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageEntity<T> extends BasePageEntity<T> {

    /** 总页码数 **/
    private Long total;
    /** 当前页码 **/
    private Long current;
    /** 上一页 **/
    private Long pre;
    /** 下一页 **/
    private Long next;
    /** 当前页面数据 **/
    private List<T> list;

}
