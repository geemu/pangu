package com.github.geemu.pangu.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-04-17 11:51:04
 */
@Data
public class UserEntity {

    private Long id;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Boolean deleted;
    private Long version;
    private Boolean enabled;
    private String account;
    private String password;

}
