package com.act.spring_boot_basics.service.impl;

import com.act.spring_boot_basics.Dto.RequestDto;
import com.act.spring_boot_basics.entity.User;
import com.act.spring_boot_basics.repository.UserRepository;
import com.act.spring_boot_basics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(RequestDto requestDto) {
        return userRepository.save(requestDto);
    }
}
