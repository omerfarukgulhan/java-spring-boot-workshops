package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("John", "Dove", "dove@gmail.com");

        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 student objects ...");
        Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@gmail.com");

        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object");
        Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("saved student. Generated id: " + tempStudent.getId());
    }

}
