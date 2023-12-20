package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import com.example.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createCourseAndReviews(appDAO);
//            retriveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);
        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;

        System.out.println("Deleting course id: " + id);

        appDAO.deleteCourseById(id);
    }

    private void retriveCourseAndReviews(AppDAO appDAO) {
        int id = 10;

        Course course = appDAO.findCourseAndReviewsByCourseId(id);

        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("spanish opening");

        course.addReview(new Review("great opening"));
        course.addReview(new Review("cool opening"));
        course.addReview(new Review("boring opening"));

        System.out.println(course);
        System.out.println(course.getReviews());

        appDAO.save(course);
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;

        Course course = appDAO.findCourseById(id);

        System.out.println("Before update: " + course);

        course.setTitle("Italian Opening");
        appDAO.update(course);

        System.out.println("After update: " + course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);

        System.out.println("Before update: " + instructor);

        instructor.setFirstName("Omer Faruk");
        appDAO.update(instructor);

        System.out.println("After update: " + instructor);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courses);

        System.out.println("Courses: " + instructor.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id = 1;

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());

    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Omer", "Gulhan", "gulhanomerf@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "chess");

        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving instructor..." + instructor);

        Course course1 = new Course("london opening");
        Course course2 = new Course("sicilian defense");
        Course course3 = new Course("caro-kann defence");

        instructor.add(course1);
        instructor.add(course2);
        instructor.add(course3);

        System.out.println("Saving instructor: " + instructor);
        System.out.println("Courses: " + instructor.getCourses());

        appDAO.save(instructor);
        System.out.println("Finished");
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
