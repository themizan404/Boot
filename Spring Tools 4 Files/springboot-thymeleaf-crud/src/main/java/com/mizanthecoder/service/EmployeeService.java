package com.mizanthecoder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mizanthecoder.dao.IEmployeeDAO;
import com.mizanthecoder.model.Employee;



@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeDAO iEmployeeDAO;

	@Override
	public List<Employee> getAllEmployees() {

		return iEmployeeDAO.findAll();
	}

	@Override
	public void save(Employee employee) {
		
		this.iEmployeeDAO.save(employee);
	}

	@Override
	public Employee getByEmployeeId(long id) {

		Optional<Employee> optional = iEmployeeDAO.findById(id);

		Employee employee = null;

		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}
	
	@Override
	public void deleteEmployeeById(long id) {
		this.iEmployeeDAO.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.iEmployeeDAO.findAll(pageable);
	}

}
