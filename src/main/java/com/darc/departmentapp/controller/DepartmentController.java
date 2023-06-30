package com.darc.departmentapp.controller;

import com.darc.departmentapp.entity.Department;
import com.darc.departmentapp.service.DepartmentService;
import com.darc.departmentapp.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDeptList() {
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
}