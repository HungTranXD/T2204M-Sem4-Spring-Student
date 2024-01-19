package com.example.faiuniversitydemo.dao;

import com.example.faiuniversitydemo.entity.Student;

import java.util.List;

public interface IStudentDAO {
    void save(Student student);

    List<Student> getStudents();

    Student getStudentById(int id);

    void update(Student student);

    void delete(Long id);

//    this is a test
}
