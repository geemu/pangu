package com.github.geemu.pangu.backend.domain.entity.view;

import com.github.geemu.pangu.backend.domain.entity.PermissionEntity;
import com.github.geemu.pangu.backend.domain.entity.UserRoleEntity;
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
public class RolePermissionViewEntity extends UserRoleEntity {

    private Set<PermissionEntity> permissions;

}
