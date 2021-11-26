package com.xinco.aracrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xinco.aracrm.entity.Employee;
import com.xinco.aracrm.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeViewController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model, @RequestParam(name = "sort", required = false) String sort) {
		
		List<Employee> employees;
		if (sort != null) {
			int sortField = Integer.parseInt(sort);
			employees = employeeService.findAllSortBy(sortField);
		} else {
			employees = employeeService.findALL();
		}
		
		model.addAttribute("employees", employees);
		return "list-employee";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeID") int id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeID") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/search")
	public String searchEmployee(@RequestParam("keyword") String keyword,Model model) {
		if (keyword.isEmpty()) {
			return "redirect:/employees/list";
		}
		List<Employee> employees = employeeService.search(keyword);
		model.addAttribute("employees", employees);
		return "list-employee";
	}
	
}
