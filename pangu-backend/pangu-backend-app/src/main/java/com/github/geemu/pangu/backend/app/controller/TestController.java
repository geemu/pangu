package com.github.geemu.pangu.backend.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author chenfangming
 */
@Api(tags = "测试")
@RestController
@RequestMapping("test")
public class TestController {

    @ApiOperation("当前时间")
    @GetMapping
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

}
