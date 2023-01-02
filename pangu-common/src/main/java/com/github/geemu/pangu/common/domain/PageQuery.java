package com.github.geemu.pangu.common.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * BasePageEntity
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-12-24 22:43:43
 */
@Data
@SuperBuilder
public class PageQuery {

    /** 页码(从1开始,小于1按照1算,大于最大页码按照最大算) **/
    private Long pageNo;
    /** 页面大小(默认15,超过1000按照15算) **/
    private Long pageSize;

}
