package com.act.springbootoath_login_with_social.model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<String> getAllProducts(){
        return Arrays.asList("Sumsung", "iPhone", "Others");
    }


    @GetMapping("/ ff")
    public String update(){
        return "Only logged in users can access this end-point";
    }
}
