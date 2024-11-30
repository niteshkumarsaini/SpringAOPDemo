package com.aop.AOPDemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aop.AOPDemo.Model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
