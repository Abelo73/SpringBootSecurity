package com.act.springbootsecurity_2.controller;

import com.act.springbootsecurity_2.dto.UserRequestDto;
import com.act.springbootsecurity_2.modal.Student;
import com.act.springbootsecurity_2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {



    @Autowired
    private StudentRepository studentRepository;




    @GetMapping("/")
    public String home(){
        return "Welcome to Home page";
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody UserRequestDto userRequestDto){
        Student student = new Student(
                userRequestDto.getId(),
                userRequestDto.getFirstName(),
                userRequestDto.getLastName(),
                userRequestDto.getEmail(),
                userRequestDto.getRole(),
                userRequestDto.getPassword()
        );
        student.studentRepository.save(userRequestDto);

    }
}
