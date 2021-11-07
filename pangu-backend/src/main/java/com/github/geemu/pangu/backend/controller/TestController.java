package com.github.geemu.pangu.backend.controller;

import com.github.geemu.pangu.backend.entity.BackendUserEntity;
import com.github.geemu.pangu.backend.mapper.BackendUserMapper;
import com.github.geemu.pangu.backend.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * @author chenfangming
 */
@RestController
@RequestMapping("test")
//@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TestController {

    @Autowired
    private BackendUserMapper backendUserMapper;
    @Autowired
    private BackendUserService backendUserService;

    @GetMapping("LocalDateTime")
    public LocalDateTime LocalDateTime() {
        return backendUserService.now();
    }

    @GetMapping("LocalDateTime/put")
    public LocalDate putLocalDateTime(@RequestParam("time") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate time) {
        return time;
    }

    @GetMapping("LocalDate")
    public LocalDate LocalDate() {
        return LocalDate.now();
    }

    @GetMapping("LocalTime")
    public LocalTime LocalTime() {
        return LocalTime.now();
    }

    @GetMapping("MonthDay")
    public MonthDay MonthDay() {
        return MonthDay.now();
    }

    @GetMapping("{id}")
    public BackendUserEntity selectById(@PathVariable("id") Long id) {
        return backendUserMapper.selectById(id);
    }


}
