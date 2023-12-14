package com.act.springbootjwt_4.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/greating")
public class GreatingController {



    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello Abel");
    }


    @GetMapping("/goodbye")
    public ResponseEntity<String> sayGoodBay(){
        return ResponseEntity.ok("Good bye");
    }
}
