package com.github.geemu.core.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * BaseVersionEntity
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-12-19 00:20:16
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseVersionEntity extends BaseEntity {

    /** 乐观锁版本号 **/
    private Long version;

}
