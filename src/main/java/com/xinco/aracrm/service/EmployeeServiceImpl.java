package com.xinco.aracrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xinco.aracrm.dao.EmployeeDAO;
import com.xinco.aracrm.dao.EmployeeRepository;
import com.xinco.aracrm.entity.Employee;
import com.xinco.aracrm.util.SortParams;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("jpa")
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findALL() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	public List<Employee> search(String keyword) {
		// TODO Auto-generated method stub
		return employeeRepository.findDistinctEmployeeByFirstNameOrLastName(keyword, keyword);
	}

	public List<Employee> findAllSortBy(int sortField){
		switch (sortField) {
		case SortParams.FIRST_NAME:
			return employeeRepository.findAllByOrderByFirstNameAsc();
		case SortParams.LAST_NAME:
			return employeeRepository.findAllByOrderByLastNameAsc();
		case SortParams.EMAIL:
			return employeeRepository.findAllByOrderByEmailAsc();
		}
		
		return findALL();
		
	}
}
