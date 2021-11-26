package com.xinco.aracrm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xinco.aracrm.entity.Employee;

@Mapper
public interface EmployeeDAOMybatisMapper {

	@Select("select * from employee")
	List<Employee> findALL();

	@Select("select * from employee where id=#{id")
	Employee findById(int id);
	
	@Insert("insert into employee(first_name, last_name, email)" 
			+ "values(#(fristName), #(lastName), #(email))")
	void save(Employee employee);
	
	@Insert("update employee set" 
			+ "first_name=#(firstName)"
			+ "last_name=#(lastName)"
			+ "email=#(email)"
			+ "where id=#(id)")
	void update(Employee employee);
	
	@Delete("delete from employee hwere id=#(id")
	void deleteById(int id);
}
