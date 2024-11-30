package com.aop.AOPDemo.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aop.AOPDemo.Model.Employee;
import com.aop.AOPDemo.Services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		// TODO Auto-generated constructor stub
		this.employeeService = employeeService;
	}

	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable("empId") int empId) {
		Employee employee = employeeService.getEmployee(empId);

		return ResponseEntity.ok(employee);
	}

	@PostMapping()
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp) {

		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(emp));
	}

	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(employeeService.getAllEmployees());

	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<?>deleteEmployee(@PathVariable("empId") int empId){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.remove(empId));
	}
	

}
