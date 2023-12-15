package com.act.login_regis_spring.service;


import com.act.login_regis_spring.dto.EmployeeDto;
import com.act.login_regis_spring.dto.LoginDto;
import com.act.login_regis_spring.entity.Employee;
import com.act.login_regis_spring.response.LoginResponse;
import com.act.login_regis_spring.response.RegistrationResponse;

import java.util.List;


//@Service
public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDto);

    LoginResponse loginEmployee(LoginDto loginDto);

    public List<Employee> getAllEmployees();

    public RegistrationResponse saveEmployee(EmployeeDto employeeDto);

//    String addEmployee(EmployeeDto employeeDto);

}
