package com.studentmanagementsystem.model;

import com.studentmanagementsystem.dto.StudentDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "student_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Age")
    private int age;
    @Column(name = "Email")
    private String email;
    @Column(name = "Address")
    private String address;

    public Student(StudentDTO studentDTO) {
        this.name = studentDTO.name;
        this.age = studentDTO.age;
        this.email = studentDTO.email;
        this.address = studentDTO.address;
    }
}
