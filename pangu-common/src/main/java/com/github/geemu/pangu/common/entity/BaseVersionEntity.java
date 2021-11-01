package com.github.geemu.pangu.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * 基础乐观锁实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel("基础乐观锁实体")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseVersionEntity extends BaseEntity {

    @ApiModelProperty("版本号->乐观锁字段")
    @Version
    @TableField("VERSION")
    private Long version;

}
