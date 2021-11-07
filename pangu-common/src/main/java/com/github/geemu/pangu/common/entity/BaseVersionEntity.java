package com.github.geemu.pangu.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;

/**
 * 基础乐观锁实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
@Accessors(chain = true)
public class BaseVersionEntity extends BaseEntity {

    @ApiModelProperty("版本号->乐观锁字段")
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
