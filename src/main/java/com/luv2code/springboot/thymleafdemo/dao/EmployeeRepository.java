package com.luv2code.springboot.thymleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	//that's it no need to write any code
	
	//Add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
