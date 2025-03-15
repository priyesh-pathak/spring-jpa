package com.example.jpa.controller;
import com.example.jpa.entity.DepartmentEntity;
import com.example.jpa.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path="/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }
    @PostMapping
    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.createDepartment(departmentEntity);
    }

    @PutMapping(path="/{departmentId}/manager/{employeeId}")
    public DepartmentEntity updateManager(@PathVariable Long departmentId,
                                          @PathVariable Long employeeId){
        return departmentService.updateManager(departmentId, employeeId);
    }

    @GetMapping(path="/manager/{id}")
    public DepartmentEntity getDepartmentIdByManagerId(@PathVariable Long id) {
        return departmentService.getDepartmentIdByManagerId(id);
    }

    @PutMapping(path="/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment(@PathVariable Long departmentId,
                                                     @PathVariable Long employeeId){
        return departmentService.assignWorkerToDepartment(departmentId, employeeId);
    }
    @PutMapping(path="/{departmentId}/freelance/{employeeId}")
    public DepartmentEntity assignFreelancerToDepartment(@PathVariable Long departmentId,
                                                     @PathVariable Long employeeId){
        return departmentService.assignFreelancerToDepartment(departmentId, employeeId);
    }
}
