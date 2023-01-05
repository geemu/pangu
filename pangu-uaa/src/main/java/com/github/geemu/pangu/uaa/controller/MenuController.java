package com.github.geemu.pangu.uaa.controller;

import com.github.geemu.pangu.common.domain.BaseResponse;
import com.github.geemu.pangu.uaa.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * MenuController
 * @author 陈方明  cfmmail@sina.com
 * @since 2022-02-19 20:51:10
 */
@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
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
