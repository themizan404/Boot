package com.mizanthecoder.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mizanthecoder.model.Employee;

public interface IEmployeeService {
	List<Employee> getAllEmployees();

	void save(Employee employee);

	Employee getByEmployeeId(long id);

	void deleteEmployeeById(long id);

	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
