package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import lombok.Builder;

@SpringBootTest
class DepartmentServiceTest {
	 @Autowired
	    private DepartmentService departmentService;

	   @MockBean
	    private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		Department department =
               new Department("IT","Banglore","IT-06" );

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
	}
	
	@Test
	 public void whenValidDepartmentName_thenDepartmentShouldFound() {
	        String departmentName = "IT";
	        Department found =
	                departmentService.fetchDepartmentByName(departmentName);

	        assertEquals(departmentName, found.getDepartmentName());
	    }
	

}
