package com.example.faiuniversitydemo;

import com.example.faiuniversitydemo.dao.IStudentDAO;
import com.example.faiuniversitydemo.dao.StudentDAO;
import com.example.faiuniversitydemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    private final IStudentDAO studentDAO;

    public Application(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
            System.out.println("Start project");

            // Save a sample student
            Student sampleStudent = new Student();
            sampleStudent.setFirst_name("John");
            sampleStudent.setLast_name("Doe");
            sampleStudent.setEmail("john.doe@example.com");
            studentDAO.save(sampleStudent);

            // Get all students and print them
//            List<Student> students = studentDAO.getStudents();
//            System.out.println("All Students:");
//            students.forEach(System.out::println);

            // Get a student by ID and print it
            int sampleStudentId = 1;
            Student foundStudent = studentDAO.getStudentById(sampleStudentId);
            System.out.println("Student found by ID " + sampleStudentId + ": " + foundStudent.toString());
        };
    }


}
