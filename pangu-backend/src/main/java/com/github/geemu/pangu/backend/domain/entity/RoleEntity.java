package com.github.geemu.pangu.backend.domain.entity;

import com.github.geemu.core.entity.BaseVersionEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 角色
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-04-17 11:51:04
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseVersionEntity {

    private Boolean enabled;
    private String code;
    private String name;
    private String remark;

}
