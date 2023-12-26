package com.act.spring_boot_curd_basics.controllers;


import com.act.spring_boot_curd_basics.dto.RequestDto;
import com.act.spring_boot_curd_basics.dto.ResponseDto;
import com.act.spring_boot_curd_basics.entity.Customers;
import com.act.spring_boot_curd_basics.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")

public class CustmerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/all")
    public List<Customers>  getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/getById/{id}")
    public Optional<Customers> getCustomerById(@PathVariable("id") @RequestBody Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/save")
    public ResponseDto saveCustomers(@RequestBody RequestDto requestDto){
        return customerService.saveCustomers(requestDto);
    }
//    @PostMapping("/saveCustomerWithPhoto")
//    public ResponseDto saveCustomerWithPhoto(@RequestBody RequestDto requestDto, @RequestPart("photo") MultipartFile photo) throws IOException {
//        return customerService.saveCustomerWithPhoto(requestDto, photo);
//    }
    @PostMapping("/saveAll")
    public ResponseDto saveAllCustomers(@RequestBody List<RequestDto> requestDto){
        return customerService.saveAllCustomers((List<RequestDto>) requestDto);
    }
    @DeleteMapping("deleteCustomer/{id}")
    public ResponseDto deleteCustomer(@PathVariable("id") Long id, ResponseDto responseDto) {
        return customerService.deleteCustomer(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto updateCustomer(@PathVariable("id") Long id, @RequestBody RequestDto requestDto){
        return customerService.updateCustomer(id, requestDto);
    }

//    UploadingPhoto

    @PostMapping("/savePhot")
    public ResponseDto uplaodPhoto(@RequestBody MultipartFile photo) throws IOException {
        return customerService.uplaodPhoto(photo);
    }

}
