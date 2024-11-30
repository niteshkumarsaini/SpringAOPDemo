package com.aop.AOPDemo.Services;

import java.util.List;

import com.aop.AOPDemo.Model.Employee;

public interface EmployeeService {
	
	
	Employee create(Employee emp);
	boolean remove(int empId);
	Employee getEmployee(int empId);
	List<Employee>getAllEmployees();
	

}
