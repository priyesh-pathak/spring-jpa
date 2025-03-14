package com.example.jpa.controller;

import com.example.jpa.entity.EmployeeEntity;
import com.example.jpa.services.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.createEmployee(employee);
    }
}
