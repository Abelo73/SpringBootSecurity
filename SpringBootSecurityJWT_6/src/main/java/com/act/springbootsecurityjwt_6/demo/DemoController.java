package com.act.springbootsecurityjwt_6.demo;


import com.act.springbootsecurityjwt_6.config.JwtService;
import com.act.springbootsecurityjwt_6.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    private final JwtService jwtService;



    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = jwtService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
