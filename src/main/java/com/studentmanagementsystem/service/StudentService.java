package com.studentmanagementsystem.service;

import com.studentmanagementsystem.dto.StudentDTO;
import com.studentmanagementsystem.exception.StudentException;
import com.studentmanagementsystem.model.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IstudentService {
    @Autowired
    StudentRepository repository;

    //--------------------------------- Add Student ---------------------------------
    @Override
    public Student addNewStudent(StudentDTO studentDTO) {
        String newEmail = studentDTO.getEmail();
        Student existingEmail = repository.findByEmail(newEmail);
        if (existingEmail != null) {
            throw new StudentException("Student already exists with the same email.");
        }
        Student student = new Student(studentDTO);
        return repository.save(student);
    }

    //--------------------------------- Get Student By Id ---------------------------------
    @Override
    public Student getStudentById(int id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        throw new StudentException("Student not found from id " + id + " Invalid Id");
    }

    //--------------------------------- Get All Student Record ---------------------------------
    @Override
    public List<Student> getAllStudentRecords() {
        return repository.findAll();
    }

    //--------------------------------- Update Student Record ---------------------------------
    @Override
    public Student updateStudent(int id, StudentDTO studentDTO) {
        Student studentData = this.getStudentById(id);
        if (studentData == null) {
            throw new StudentException("Student not found with Id: " + id);
        }
        if (repository.findByEmail(studentDTO.getEmail()) == null) {
            if (studentDTO.getEmail() != null) {
                studentData.setEmail(studentDTO.email);
            }
            if (studentDTO.getName() != null) {
                studentData.setName(studentDTO.name);
            }
            if (studentDTO.getAge() != 0) {
                studentData.setAge(studentDTO.age);
            }
            if (studentDTO.getAddress() != null) {
                studentData.setAddress(studentDTO.address);
            }
            return repository.save(studentData);
        }
        throw new StudentException(studentDTO.getEmail() + " This name is already exist." + " please try with another name");

    }

    //--------------------------------- Delete Student Record ---------------------------------
    @Override
    public String deleteStudentRecord(int id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return "Data Deleted successful";
        }
        throw new StudentException("Student not found from Id " + id + " Invalid Id ");
    }
}