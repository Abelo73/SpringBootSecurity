package com.act.login_regis_spring.controller;


import com.act.login_regis_spring.dto.EmployeeDto;
import com.act.login_regis_spring.dto.LoginDto;
import com.act.login_regis_spring.entity.Employee;
import com.act.login_regis_spring.response.LoginResponse;
import com.act.login_regis_spring.response.RegistrationResponse;
import com.act.login_regis_spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "http://localhost:3000") // Add this line to enable CORS for the specified origin

public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;
//
//    @PostMapping("/save")
//    public String saveEmployee(@RequestBody EmployeeDto employeeDto){
//        return employeeService.addEmployee(employeeDto);
//    }

    @PostMapping("/addEmployee")
    @CrossOrigin(origins = "http://localhost:3000") // Add this line to enable CORS for the specified origin

    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto){

        RegistrationResponse registrationResponse = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.ok(registrationResponse);



    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000") // Add this line to enable CORS for the specified origin

    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);

        return ResponseEntity.ok(loginResponse);
    }




    @GetMapping("/getAllEmployees")
    @CrossOrigin(origins = "http://localhost:3000") // Add this line to enable CORS for the specified origin

    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
