package com.example.faiuniversitydemo;

import com.example.faiuniversitydemo.dao.IStudentDAO;
import com.example.faiuniversitydemo.dao.StudentDAO;
import com.example.faiuniversitydemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class Application {
    @RequestMapping("/test")
    String home() {
        return "Hello World";
    }

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
            Student sampleStudent = new Student("John", "Doe", "john.doe@example.com");
            studentDAO.save(sampleStudent);

//            // Get a student by ID and print it
//            int sampleStudentId = sampleStudent.getId();
//            Student foundStudent = studentDAO.getStudentById(sampleStudentId);
//            System.out.println("Student found by ID " + sampleStudentId + ": " + foundStudent.toString());
//
//            // Get all students and print them
//            List<Student> students = studentDAO.getStudents();
//            System.out.println("All Students:");
//            students.forEach(System.out::println);
//
//            // Update student
//            foundStudent.setFirstName("Eric");
//            studentDAO.update(foundStudent);

            // Example: Delete the student
//            studentDAO.delete(2L);
        };
    }


}
