package com.act.spring_boot_curd_basics.repository;

import com.act.spring_boot_curd_basics.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Long> {
}
