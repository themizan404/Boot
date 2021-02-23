package com.mizanthecoder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mizanthecoder.model.Employee;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, Long>{

}
