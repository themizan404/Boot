package com.mizanthecoder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mizanthecoder.dao.EmployeeRepository;

import com.mizanthecoder.entity.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	private EmployeeRepository iEmployeeDAO;

	@Autowired
	public EmployeeService(EmployeeRepository theiEmployeeDAO) {

		iEmployeeDAO = theiEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return iEmployeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {

		Optional<Employee> result = iEmployeeDAO.findById(theId);

		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not get Id - " + theId);
		}
		return theEmployee;
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
