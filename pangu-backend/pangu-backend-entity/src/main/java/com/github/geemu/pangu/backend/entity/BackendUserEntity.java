package com.github.geemu.pangu.backend.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.geemu.pangu.common.entity.BaseVersionEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-04-17 11:51:04
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体")
@Accessors(chain = true)
@TableName("BACKEND_USER")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BackendUserEntity extends BaseVersionEntity {

    @ApiModelProperty("是否启用->true:启用、false:禁用")
    @TableField("ENABLED")
    private Boolean enabled;
    @ApiModelProperty("账号")
    @TableField("ACCOUNT")
    private String account;
    @ApiModelProperty("密码")
    @TableField("PASSWORD")
    private String password;

}
