package com.luv2code.springboot.thymleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result=employeeRepository.findById(theId);
		
		Employee theEmployee=null;
		
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			//we didn't find the employee at the given id
			throw new RuntimeException("Did not find employee id-"+theId); 
		}
			
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
