package com.github.geemu.pangu.backend.controller;

import com.github.geemu.pangu.backend.entity.BackendUserEntity;
import com.github.geemu.pangu.backend.mapper.BackendUserMapper;
import com.github.geemu.pangu.backend.service.BackendUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author chenfangming
 */
@Api(tags = "测试")
@RestController
@RequestMapping("test")
//@AllArgsConstructor(onConstructor_ = {@Autowired})
public class TestController {

    @Autowired
    private BackendUserMapper backendUserMapper;
    @Autowired
    private BackendUserService backendUserService;

    @ApiOperation("now")
    @GetMapping
    public LocalDateTime now() {
        return backendUserService.now();
    }

    @ApiOperation("selectById")
    @GetMapping("id/{id}")
    public BackendUserEntity selectById(@PathVariable("id") Long id) {
        System.out.println(111111);
        return backendUserMapper.selectById(id);
    }


}
