package com.studentmanagementsystem.service;

import com.studentmanagementsystem.dto.StudentDTO;
import com.studentmanagementsystem.model.Student;

import java.util.List;

public interface IstudentService {
    Student addNewStudent(StudentDTO studentDTO);

    Student getStudentById(int id);

    List<Student> getAllStudentRecords();

    Student updateStudent(int id, StudentDTO studentDTO);

    String deleteStudentRecord(int id);
}
