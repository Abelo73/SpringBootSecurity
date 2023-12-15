package com.act.springsecurity_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CustomUserDetails customUserDetails;


    @GetMapping("/")
    public String all(){
        return "This is No Permission Required";
    }


    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        return customUserDetails.getAllUsers();
    }

    @GetMapping("/home")
    public String home(){
        return "This is Homepage";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody UserDto userDto){
        String id = customUserDetails.addUser(userDto);

        return id;
    }



    @GetMapping("/admin")
    public String admin(){
        return "This is Admin page";
    }


}
