package com.darc.departmentapp.service;

import com.darc.departmentapp.entity.Department;
import com.darc.departmentapp.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository repository;

    @BeforeEach
    void setUp() {

        Department department =
                Department.builder()
                .departmentName("IT")
                .departmentAddress("Lagos")
                .departmentCode("IT-01")
                .departmentId(1L)
                .build();

        Mockito.when(repository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid department name")
    public void whenValidDeptName_thenDeptShouldBeFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDeptByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}