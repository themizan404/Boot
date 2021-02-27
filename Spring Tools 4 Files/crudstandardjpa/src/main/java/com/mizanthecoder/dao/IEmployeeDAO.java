package com.mizanthecoder.dao;

import java.util.List;

import com.mizanthecoder.entity.Employee;

public interface IEmployeeDAO {
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);
}
