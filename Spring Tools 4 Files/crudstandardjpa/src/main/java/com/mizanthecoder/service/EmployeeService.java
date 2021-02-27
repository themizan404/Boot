package com.mizanthecoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mizanthecoder.dao.IEmployeeDAO;
import com.mizanthecoder.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	@Qualifier(value = "employeeJpaDAO")
	IEmployeeDAO iEmployeeDAO;

	@Override
	public List<Employee> findAll() {
		return iEmployeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return iEmployeeDAO.findById(theId);
	}

	@Override
	public void save(Employee theEmployee) {
		iEmployeeDAO.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		iEmployeeDAO.deleteById(theId);

	}

}
