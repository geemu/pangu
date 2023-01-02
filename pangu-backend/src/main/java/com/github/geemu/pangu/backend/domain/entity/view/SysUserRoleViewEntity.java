package com.github.geemu.pangu.backend.domain.entity.view;

import com.github.geemu.pangu.backend.domain.entity.SysRoleEntity;
import com.github.geemu.pangu.backend.domain.entity.SysUserRoleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-04-17 11:51:04
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUserRoleViewEntity extends SysUserRoleEntity {

    private Set<SysRoleEntity> roles;

}
