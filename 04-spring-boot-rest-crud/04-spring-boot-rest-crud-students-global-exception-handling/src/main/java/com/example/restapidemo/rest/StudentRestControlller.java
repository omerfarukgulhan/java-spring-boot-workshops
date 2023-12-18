package com.example.restapidemo.rest;


import com.example.restapidemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestControlller {
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Marta", "Patel"));
        students.add(new Student("Mario", "Smith"));
        students.add(new Student("Mary", "Rose"));

    }


    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }


}
