package com.act.spring_boot_basics.service;

import com.act.spring_boot_basics.Dto.RequestDto;
import com.act.spring_boot_basics.Dto.ResponseDto;
import com.act.spring_boot_basics.entity.User;
import com.act.spring_boot_basics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User addUser(RequestDto requestDto);
}
