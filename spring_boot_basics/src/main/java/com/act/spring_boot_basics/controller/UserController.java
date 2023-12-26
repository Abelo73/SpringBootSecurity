package com.act.spring_boot_basics.controller;

import com.act.spring_boot_basics.Dto.RequestDto;
import com.act.spring_boot_basics.Dto.ResponseDto;
import com.act.spring_boot_basics.entity.User;
import com.act.spring_boot_basics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/saveUser")
    public User addUser(@RequestBody RequestDto requestDto){
        return userService.addUser(requestDto);
    }
}
