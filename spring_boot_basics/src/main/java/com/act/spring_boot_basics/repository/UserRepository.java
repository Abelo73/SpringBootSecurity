package com.act.spring_boot_basics.repository;

import com.act.spring_boot_basics.Dto.RequestDto;
import com.act.spring_boot_basics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
