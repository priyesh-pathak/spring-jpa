package com.example.jpa.services;

import com.example.jpa.entity.DepartmentEntity;
import com.example.jpa.entity.EmployeeEntity;
import com.example.jpa.repository.DepartmentRepository;
import com.example.jpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }
    public DepartmentEntity createDepartment(DepartmentEntity input) {
        return departmentRepository.save(input);
    }
    public DepartmentEntity getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity updateManager(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
        return departmentEntity.flatMap((department->
                employeeEntity.map(employee-> {
                    department.setManager(employee);
                    return departmentRepository.save(department);
                }))).orElse(null);
    }

    public DepartmentEntity getDepartmentByManagerId(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeEntity.map(employee-> employee.getDep_manager()).orElse(null);
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId,Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
            return departmentEntity.flatMap(department->
                employeeEntity.map(employee-> {
                    employee.setWorkerDepartment(department);
                    employeeRepository.save(employee);
                    department.getWorkers().add(employee);
                    return department;
                })).orElse(null);
    }
}
