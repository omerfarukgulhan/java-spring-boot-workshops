package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Adding membership account.");
    }

    @Override
    public void addMethod() {
        System.out.println(getClass() + ": Add method.");
    }
}
