package com.example.faiuniversitydemo.controller;

import com.example.faiuniversitydemo.dao.IStudentDAO;
import com.example.faiuniversitydemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final IStudentDAO studentDAO;

    @Autowired
    public StudentController(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        List<Student> students = studentDAO.getStudents();
        return students;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student foundStudent = studentDAO.getStudentById(id);
        if (foundStudent != null) {
            return new ResponseEntity<>(foundStudent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/student")
    public String postStudent(@RequestBody Student newStudent) {
        studentDAO.save(newStudent);
        return "Student created successfully";
    }
}
