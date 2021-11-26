package com.xinco.aracrm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xinco.aracrm.entity.Employee;

@Repository("jpa")
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	public List<Employee> findALL() {
		TypedQuery<Employee> query = 
				entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	public Employee findById(int id) {
		
		return entityManager.find(Employee.class, id);
	}

	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();

	}

}
