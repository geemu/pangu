package com.github.geemu.pangu.uaa.domain.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * com.github.geemu.pangu.backend.domain.request
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-03-05 20:25:08
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class LoginRequest {

    private String username;
    private String password;

}
