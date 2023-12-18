package com.example.employeeapidemo.rest;

import com.example.employeeapidemo.entitiy.Employee;
import com.example.employeeapidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
