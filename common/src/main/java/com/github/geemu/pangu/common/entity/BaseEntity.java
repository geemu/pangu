package com.github.geemu.pangu.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * 基础实体
 * @author 陈方明 cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("基础实体")
@Accessors(chain = true)
@ToString(callSuper = true)
public class BaseEntity {

    @ApiModelProperty("主键")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("创建时间")
    @TableField("CREATED_AT")
    private LocalDateTime createdAt;
    @ApiModelProperty("创建人")
    @TableField("CREATED_BY")
    private String createdBy;
    @ApiModelProperty("更新时间")
    @TableField("UPDATED_AT")
    private LocalDateTime updatedAt;
    @ApiModelProperty("更新人")
    @TableField("UPDATED_BY")
    private String updatedBy;
    @ApiModelProperty("是否删除->true:未删除、false:已删除")
    @TableLogic(value = "1", delval = "1")
    @TableField("NON_DELETED")
    private Boolean nonDeleted;

}
