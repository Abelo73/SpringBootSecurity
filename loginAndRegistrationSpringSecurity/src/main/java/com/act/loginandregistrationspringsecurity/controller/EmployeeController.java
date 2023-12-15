package com.act.loginandregistrationspringsecurity.controller;


import com.act.loginandregistrationspringsecurity.dto.EmployeeDto;
import com.act.loginandregistrationspringsecurity.dto.LoginDto;
import com.act.loginandregistrationspringsecurity.entity.Employee;
import com.act.loginandregistrationspringsecurity.response.LoginResponse;
import com.act.loginandregistrationspringsecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto){
       return employeeService.addEmployee(employeeDto);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginResponse);
    }


    @GetMapping("/getAllEmployee")

    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

}
