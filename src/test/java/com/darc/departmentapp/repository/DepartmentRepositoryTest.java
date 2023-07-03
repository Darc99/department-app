package com.darc.departmentapp.repository;

import com.darc.departmentapp.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("HR")
                .departmentCode("HR - 04")
                .departmentAddress("Abuja")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDept() {
        Department department = repository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "HR");
    }
}