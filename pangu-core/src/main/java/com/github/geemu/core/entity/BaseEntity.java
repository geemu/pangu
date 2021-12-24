package com.github.geemu.core.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * BaseEntity
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-12-19 00:20:06
 */
@Data
@Builder
public class BaseEntity {

    /** 主键 **/
    private Long id;
    /** 创建人 **/
    private String createdBy;
    /** 创建时间 **/
    private LocalDateTime createdAt;
    /** 更新人 **/
    private String updatedBy;
    /** 更新时间 **/
    private LocalDateTime updatedAt;
    /** 是否删除->true:已删除、false:未删除 **/
    private Boolean deleted;

}
