package com.example.employeeapidemo.service;

import com.example.employeeapidemo.entitiy.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
