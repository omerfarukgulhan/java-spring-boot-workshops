package com.example.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach {

    public FootballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice penalty for 15 minutes";
    }
}
