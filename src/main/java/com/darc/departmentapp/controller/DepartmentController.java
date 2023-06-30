package com.darc.departmentapp.controller;

import com.darc.departmentapp.entity.Department;
import com.darc.departmentapp.service.DepartmentService;
import com.darc.departmentapp.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDept of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDeptList() {
        LOGGER.info("Inside fetchDeptList of DepartmentController");
        return departmentService.fetchDeptList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDeptById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDeptById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDeptById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDeptById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDeptByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDeptByName(departmentName);
    }
}