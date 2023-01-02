package com.github.geemu.pangu.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * BaseEntity
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-12-19 00:20:06
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {

    private Long id;//主键
    private LocalDateTime createdAt;//创建时间
    private String createdBy;//创建人
    private LocalDateTime updatedAt;//更新时间
    private String updatedBy;//更新人
    private Boolean deleted;//是否删除->true:已删除、false:未删除

}
