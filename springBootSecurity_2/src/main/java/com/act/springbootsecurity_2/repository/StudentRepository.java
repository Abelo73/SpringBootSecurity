package com.act.springbootsecurity_2.repository;

import com.act.springbootsecurity_2.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
