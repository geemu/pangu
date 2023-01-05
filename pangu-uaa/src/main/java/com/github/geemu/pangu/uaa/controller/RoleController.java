package com.github.geemu.pangu.uaa.controller;

import com.github.geemu.core.StringUtils;
import com.github.geemu.pangu.common.domain.BaseResponse;
import com.github.geemu.pangu.common.domain.DefaultResponseState;
import com.github.geemu.pangu.common.exception.BizRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * RoleController
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-02-19 20:51:10
 */
@RestController
@RequestMapping("role")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RoleController {

    @GetMapping("user_role")
    public BaseResponse<List<String>> getUserRole(@RequestHeader("X-USER-TOKEN") String token) {
        if (StringUtils.isBlank(token)) {
            throw new BizRuntimeException(DefaultResponseState.SERVER_ERROR);
        }
        List<String> list = new ArrayList<>();
        list.add("添加用户");
        list.add("删除用户");
        list.add("修改用户");
        list.add("查询用户");
        return BaseResponse.ok(list);
    }

    @PostMapping
    public BaseResponse<Void> add() {
        return BaseResponse.ok();
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
