package com.github.geemu.pangu.backend.entity;

import com.github.geemu.core.entity.BaseVersionEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-04-17 11:51:04
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseVersionEntity {

    private Boolean enabled;
    private String account;
    private String password;
    private String empNo;

}
