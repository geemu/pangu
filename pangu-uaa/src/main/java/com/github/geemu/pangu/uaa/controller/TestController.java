package com.github.geemu.pangu.uaa.controller;

import com.github.geemu.pangu.uaa.domain.entity.SysUserEntity;
import com.github.geemu.pangu.uaa.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.*;

/**
 * @author chenfangming
 */
@RestController
@RequestMapping("test")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TestController {

    private final SysUserMapper backendUserMapper;

    @GetMapping("localDateTime")
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    @GetMapping("localDate")
    public LocalDate localDate() {
        return LocalDate.now();
    }

    @GetMapping("localTime")
    public LocalTime localTime() {
        return LocalTime.now();
    }

    @GetMapping("yearMonth")
    public YearMonth yearMonth() {
        return YearMonth.now();
    }

    @GetMapping("monthDay")
    public MonthDay monthDay() {
        return MonthDay.now();
    }

    @GetMapping("{id}")
    public SysUserEntity selectById(@PathVariable("id") Long id) {
        return backendUserMapper.selectById(id);
    }

    @PostMapping("hook")
    public LocalDateTime hook() {
        return LocalDateTime.now();
    }

}
