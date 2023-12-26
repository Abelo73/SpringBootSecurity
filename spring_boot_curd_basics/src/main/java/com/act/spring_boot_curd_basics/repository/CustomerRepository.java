package com.act.spring_boot_curd_basics.repository;

import com.act.spring_boot_curd_basics.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    boolean existsByEmail(String email);

}
