package com.github.geemu.pangu.backend.controller;

import com.github.geemu.core.domain.ResponseEntity;
import com.github.geemu.pangu.backend.service.UserService;
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
    public ResponseEntity<Void> add() {
        return ResponseEntity.ok();
    }

    @DeleteMapping
    public ResponseEntity<Void> remove() {
        return ResponseEntity.ok();
    }

    @PutMapping
    public ResponseEntity<Void> edit() {
        return ResponseEntity.ok();
    }

    @GetMapping
    public ResponseEntity<Void> query() {
        return ResponseEntity.ok();
    }

}
