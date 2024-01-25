package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Member;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
            demoTheBeforeAdvice(accountDAO, membershipDAO);
        };
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
