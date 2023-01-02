package com.github.geemu.pangu.backend.controller;

import com.github.geemu.core.UUIDUtils;
import com.github.geemu.pangu.backend.domain.request.LoginRequest;
import com.github.geemu.pangu.backend.service.UserService;
import com.github.geemu.pangu.common.domain.BaseResponse;
import com.github.geemu.pangu.common.domain.DefaultResponseState;
import com.github.geemu.pangu.common.exception.BizRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-02-19 20:51:10
 */
@RestController
@RequestMapping("login")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LoginController {

    private final UserService userService;

    @PostMapping
    public BaseResponse<String> login(@RequestBody LoginRequest request) {
        if (!"admin".equalsIgnoreCase(request.getUsername())) {
            throw new BizRuntimeException(DefaultResponseState.SERVER_ERROR);
        }
        if (!"admin".equalsIgnoreCase(request.getPassword())) {
            throw new BizRuntimeException(DefaultResponseState.SERVER_ERROR);
        }
        return BaseResponse.ok(UUIDUtils.uuid());
    }

}
