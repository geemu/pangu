package com.github.geemu.pangu.backend.service.impl;

import com.github.geemu.pangu.backend.service.BackendUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * com.github.geemu.pangu.backend.service.impl
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-11-07 12:41
 */
@Service
public class BackendUserServiceImpl implements BackendUserService {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

}
