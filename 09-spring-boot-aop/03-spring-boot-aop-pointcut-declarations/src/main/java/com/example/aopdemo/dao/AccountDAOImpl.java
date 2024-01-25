package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    @Override
    public void addAccount(Account account,boolean vipFlag) {
        System.out.println(getClass() + ": Adding account.");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": Do work.");

        return false;
    }
}
