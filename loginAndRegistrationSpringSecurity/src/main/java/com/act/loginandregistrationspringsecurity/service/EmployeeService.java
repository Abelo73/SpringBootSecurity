package com.act.loginandregistrationspringsecurity.service;


import com.act.loginandregistrationspringsecurity.dto.EmployeeDto;
import com.act.loginandregistrationspringsecurity.dto.LoginDto;
import com.act.loginandregistrationspringsecurity.entity.Employee;
import com.act.loginandregistrationspringsecurity.response.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    String addEmployee(EmployeeDto employeeDto);

    LoginResponse loginEmployee(LoginDto loginDto);


    List<Employee> getAll();
}
