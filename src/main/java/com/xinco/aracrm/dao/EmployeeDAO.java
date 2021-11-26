package com.xinco.aracrm.dao;

import java.util.List;

import com.xinco.aracrm.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findALL();

	Employee findById(int id);
	
	void save(Employee employee);
	
	void deleteById(int id);
}
