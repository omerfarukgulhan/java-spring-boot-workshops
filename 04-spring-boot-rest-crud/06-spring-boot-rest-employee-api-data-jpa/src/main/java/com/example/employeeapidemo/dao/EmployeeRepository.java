package com.example.employeeapidemo.dao;

import com.example.employeeapidemo.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
