package com.example.restapidemo.rest;


import com.example.restapidemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestControlller {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Marta", "Patel"));
        students.add(new Student("Mario", "Smith"));
        students.add(new Student("Mary", "Rose"));

        return students;
    }
}
