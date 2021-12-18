package com.github.geemu.pangu.common.entity;

/**
 * 基础乐观锁实体
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-01-17 22:20
 */
public class BaseVersionEntity extends BaseEntity {

    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
