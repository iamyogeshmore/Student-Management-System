package com.studentmanagementsystem.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
public @ToString class StudentDTO {
    public String name;
    public int age;
    public String email;
    public String address;
}
