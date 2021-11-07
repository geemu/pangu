package com.github.geemu.pangu.backend.app.controller;

import com.github.geemu.pangu.backend.app.entity.BackendUserEntity2;
import com.github.geemu.pangu.backend.app.mapper.BackendUserMapper;
import com.github.geemu.pangu.backend.app.mapper.BackendUserMapper2;
import com.github.geemu.pangu.backend.entity.BackendUserEntity;
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
    private BackendUserMapper2 backendUserMapper2;

    @ApiOperation("now")
    @GetMapping
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    @ApiOperation("selectById")
    @GetMapping("id/{id}")
    public BackendUserEntity selectById(@PathVariable("id") Long id) {
        return backendUserMapper.selectById(id);
    }

    @ApiOperation("selectById2")
    @GetMapping("id2/{id}")
    public BackendUserEntity2 selectById2(@PathVariable("id") Long id) {
        return backendUserMapper2.selectById2(id);
    }

}
