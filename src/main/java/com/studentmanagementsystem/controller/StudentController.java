package com.studentmanagementsystem.controller;

import com.studentmanagementsystem.dto.ResponseDTO;
import com.studentmanagementsystem.dto.StudentDTO;
import com.studentmanagementsystem.model.Student;
import com.studentmanagementsystem.service.IstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    IstudentService service;
    List<Student> studentList = new ArrayList<>();

    //--------------------------------- Add Student ---------------------------------
    @PostMapping("/addStudent")
    public ResponseEntity<ResponseDTO> addNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = service.addNewStudent(studentDTO);
        ResponseDTO responseDTO = new ResponseDTO("Student added successfully.", student);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Student By Id ---------------------------------
    @GetMapping("getStudentById")
    public ResponseEntity<ResponseDTO> studentFindById(@RequestParam("id") int id) {
        Student student = service.getStudentById(id);
        ResponseDTO responseDTO = new ResponseDTO("Student Details of id " + id, student);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get All Student Records ---------------------------------
    @GetMapping("getAllStudentRecords")
    public ResponseEntity<ResponseDTO> AllStudentRecords() {
        studentList = service.getAllStudentRecords();
        ResponseDTO responseDTO = new ResponseDTO("We have " + studentList.size() + " Students.", studentList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Update Student By Id ---------------------------------
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<ResponseDTO> updateStudent(@PathVariable("id") int id, @RequestBody StudentDTO studentDTO) {
        Student studentData = service.updateStudent(id, studentDTO);
        ResponseDTO responseDTO = new ResponseDTO("Student data updated successfully of Id " + id + "", studentData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete Student By Id ---------------------------------
    @DeleteMapping("/deleteStudentRecord/{id}")
    public ResponseEntity<ResponseDTO> deleteStudentRecord(@PathVariable("id") int id) {
        service.deleteStudentRecord(id);
        ResponseDTO responseDTO = new ResponseDTO("Student records clear of Id " + id + "", "Deleted id: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
