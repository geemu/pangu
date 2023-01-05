package com.github.geemu.pangu.uaa.controller;

import com.github.geemu.pangu.backend.service.UserService;
import com.github.geemu.pangu.common.domain.BaseResponse;
import com.github.geemu.pangu.uaa.domain.entity.SysUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-02-19 20:51:10
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {

    private final UserService userService;

    @PostMapping
    public BaseResponse<Long> add(@RequestBody SysUserEntity entity) {
        return BaseResponse.ok(userService.add(entity));
    }

    @DeleteMapping
    public BaseResponse<Void> remove() {
        return BaseResponse.ok();
    }

    @PutMapping
    public BaseResponse<Void> edit() {
        return BaseResponse.ok();
    }

    @GetMapping
    public BaseResponse<Void> query() {
        return BaseResponse.ok();
    }

}
