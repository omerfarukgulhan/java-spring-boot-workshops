package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public void setCoach(@Qualifier("footballCoach") Coach theCoach, @Qualifier("footballCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        anotherCoach = theAnotherCoach;
        myCoach = theCoach;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
