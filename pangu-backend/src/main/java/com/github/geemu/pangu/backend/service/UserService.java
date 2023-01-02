package com.github.geemu.pangu.backend.service;

import com.github.geemu.pangu.backend.domain.entity.SysUserEntity;

/**
 * 用户
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-11-07 12:41
 */
public interface UserService {


    long add(SysUserEntity userEntity);

}
