package com.darc.departmentapp.service;

import com.darc.departmentapp.entity.Department;
import com.darc.departmentapp.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDeptList();

    public Department fetchDeptById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDeptById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDeptByName(String departmentName);
}
