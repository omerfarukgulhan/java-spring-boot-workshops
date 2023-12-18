package com.example.employeeapidemo.dao;

import com.example.employeeapidemo.entitiy.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void delete(int id);


}
