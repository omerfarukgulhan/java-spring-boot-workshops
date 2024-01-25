package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

//    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(void add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*(com.example.aopdemo.Account))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*(com.example.aopdemo.Account,..))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=> Executing @Before advice on addAccount()");
//    }

//    @Before("execution(* add*(..))")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=> Executing @Before advice on addAccount()");
//    }

    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=> Executing @Before advice on addAccount()");
    }
}
