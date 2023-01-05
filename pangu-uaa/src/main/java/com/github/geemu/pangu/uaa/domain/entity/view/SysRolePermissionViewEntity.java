package com.github.geemu.pangu.uaa.domain.entity.view;

import com.github.geemu.pangu.uaa.domain.entity.SysPermissionEntity;
import com.github.geemu.pangu.uaa.domain.entity.SysUserRoleEntity;
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
public class SysRolePermissionViewEntity extends SysUserRoleEntity {

    private Set<SysPermissionEntity> permissions;

}
