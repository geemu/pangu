package com.github.geemu.pangu.backend.controller;

import com.github.geemu.core.domain.BaseResponse;
import com.github.geemu.pangu.backend.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * MenuController
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-02-19 20:51:10
 */
@RestController
@RequestMapping("menu")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MenuController {

    private final MenuService menuService;

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
