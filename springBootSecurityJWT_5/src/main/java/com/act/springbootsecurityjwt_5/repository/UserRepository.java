package com.act.springbootsecurityjwt_5.repository;

import com.act.springbootsecurityjwt_5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
