package com.github.geemu.core.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * BaseEntity
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-12-19 00:20:06
 */
@Data
@SuperBuilder
public class BaseEntity {

    /** 主键 **/
    private Long id;
    /** 创建时间 **/
    private LocalDateTime createdAt;
    /** 创建人 **/
    private String createdBy;
    /** 更新时间 **/
    private LocalDateTime updatedAt;
    /** 更新人 **/
    private String updatedBy;
    /** 是否删除->true:已删除、false:未删除 **/
    private Boolean deleted;

}
