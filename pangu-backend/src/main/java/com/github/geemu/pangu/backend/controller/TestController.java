package com.github.geemu.pangu.backend.controller;

import com.github.geemu.pangu.backend.entity.UserEntity;
import com.github.geemu.pangu.backend.mapper.UserMapper;
import com.github.geemu.pangu.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.*;

/**
 * @author chenfangming
 */
@RestController
@RequestMapping("test")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TestController {

    private final UserMapper backendUserMapper;
    private final UserService backendUserService;

    @GetMapping("localDateTime")
    public LocalDateTime localDateTime() {
        return backendUserService.now();
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
    public UserEntity selectById(@PathVariable("id") Long id) {
        return backendUserMapper.selectById(id);
    }

}
