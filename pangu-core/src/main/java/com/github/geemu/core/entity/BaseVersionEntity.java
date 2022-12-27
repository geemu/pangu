package com.github.geemu.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * BaseVersionEntity
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-12-19 00:20:16
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseVersionEntity extends BaseEntity {

    private Long version;//乐观锁版本号

}
