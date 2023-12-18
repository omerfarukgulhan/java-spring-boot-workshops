package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
            deleteInstructorDetail(appDAO);
        };
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id = 2;
        System.out.println("Deleting instructor detail id: " + id);

        appDAO.deleteInstructorDetailById(id);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 2;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

        System.out.println("Instructor Detail: " + instructorDetail);

        System.out.println("Instructor: " + instructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Instructor: " + instructor);
        System.out.println("Instructor details: " + instructor.getInstructorDetail());

        appDAO.deleteInstructorById(id);
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Instructor: " + instructor);
        System.out.println("Instructor details: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Omer", "Gulhan", "gulhanomerf@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "chess");

        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving instructor..." + instructor);

        appDAO.save(instructor);

        System.out.println("Finished");
    }
}
