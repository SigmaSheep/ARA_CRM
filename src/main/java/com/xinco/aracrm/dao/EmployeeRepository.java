package com.xinco.aracrm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.xinco.aracrm.entity.Employee;

@RepositoryRestResource(path="membership")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findDistinctEmployeeByFirstNameOrLastName(String firstName, String lastName);
	
	public List<Employee> findAllByOrderByFirstNameAsc();
	
	public List<Employee> findAllByOrderByLastNameAsc();
	
	public List<Employee> findAllByOrderByEmailAsc();
}
