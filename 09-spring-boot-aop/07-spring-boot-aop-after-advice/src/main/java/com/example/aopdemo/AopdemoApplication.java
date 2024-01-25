package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Member;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
//            demoTheBeforeAdvice(accountDAO, membershipDAO);
//            demoTheAfterReturningAdvice(accountDAO);
//            demoTheAfterThrowingAdvice(accountDAO);
            demoTheAfterAdvice(accountDAO);
        };
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);

        } catch (Exception exc) {
            System.out.println("\n\nCaught exception: " + exc);
        }

        System.out.println("\n\ndemoTheAfterThrowingAdvice");
        System.out.println("******************************");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> accounts = null;

        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);

        } catch (Exception exc) {
            System.out.println("\n\nCaught exception: " + exc);
        }

        System.out.println("\n\ndemoTheAfterThrowingAdvice");
        System.out.println("******************************");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\ndemoTheAfterReturningAdvice");
        System.out.println("******************************");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        account.setName("omer");
        account.setLevel("silver");

        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        accountDAO.setName("faruk");
        accountDAO.setServiceCode("gold");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        membershipDAO.addAccount();
        membershipDAO.addMethod();
    }
}
