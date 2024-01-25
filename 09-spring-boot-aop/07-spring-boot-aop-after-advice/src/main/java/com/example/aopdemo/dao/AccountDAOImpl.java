package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("error");
        }

        List<Account> accounts = new ArrayList<>();

        Account temp1 = new Account("Asd", "Silver");
        Account temp2 = new Account("Qwe", "Platinum");
        Account temp3 = new Account("Zxc", "Gold");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Adding account.");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": Do work.");

        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode");
        this.serviceCode = serviceCode;
    }
}
