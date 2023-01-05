package com.github.geemu.pangu.uaa.domain.entity;

import com.github.geemu.pangu.common.entity.BaseVersionEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 菜单权限
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-04-17 11:51:04
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRolePermissionEntity extends BaseVersionEntity {

    private Boolean enabled;
    private Long roleId;
    private Long permissionId;
    private String remark;

}
