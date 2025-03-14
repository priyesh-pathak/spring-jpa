package com.example.jpa.services;

import com.example.jpa.entity.EmployeeEntity;
import com.example.jpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public EmployeeEntity createEmployee(EmployeeEntity input){
        return employeeRepository.save(input);
    }
    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
