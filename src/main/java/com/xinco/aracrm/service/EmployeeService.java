package com.xinco.aracrm.service;

import java.util.List;

import com.xinco.aracrm.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findALL();
	
	List<Employee> findAllSortBy(int sortFeild);

	Employee findById(int id);
	
	void save(Employee employee);
	
	void deleteById(int id);

	List<Employee> search(String keyword);
}
