package com.act.spring_boot_curd_basics.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private String name;
    private String email;
    private String phone;
}
