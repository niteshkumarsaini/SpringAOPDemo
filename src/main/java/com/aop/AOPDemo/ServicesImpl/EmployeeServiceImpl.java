package com.aop.AOPDemo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aop.AOPDemo.Model.Employee;
import com.aop.AOPDemo.Repositories.EmployeeRepo;
import com.aop.AOPDemo.Services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	

	@Override
	public Employee create(Employee emp) {
		// TODO Auto-generated method stub	
		return employeeRepo.save(emp);
	}

	@Override
	public boolean remove(int empId) {
		// TODO Auto-generated method stub
		System.out.println("Employee is deleting..");
		employeeRepo.deleteById(empId);
		return true;
	}

	@Override
	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		System.out.println("Get Single Employee method is running ");

		return employeeRepo.findById(empId).orElseThrow(()->new RuntimeException("Employee not found here"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee>allEmps=(List<Employee>)employeeRepo.findAll();
		System.out.println("Get All employees method running");
		System.out.println(allEmps);
		
		return allEmps;
	}

}
