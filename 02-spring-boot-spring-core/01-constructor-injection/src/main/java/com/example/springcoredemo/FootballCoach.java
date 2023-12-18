package com.example.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice penalty for 15 minutes";
    }
}
