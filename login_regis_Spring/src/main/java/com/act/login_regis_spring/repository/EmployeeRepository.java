package com.act.login_regis_spring.repository;


import com.act.login_regis_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {


    Optional<Employee> findOneByEmailAndPassword(String email,  String password);
    Employee findByEmail(String email);
}
