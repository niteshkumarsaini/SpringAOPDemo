package com.aop.AOPDemo.Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.aop.AOPDemo.Model.Employee;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
@Component
public class AfterReturningAspect {
	
	@AfterReturning(value = "execution(* com.aop.AOPDemo.ServicesImpl.EmployeeServiceImpl.create(..)) && args(emp)")
	public void AfterReturning(JoinPoint jp, Employee emp) {
		System.out.println("This Advice is executed after the "+jp.getSignature().getName());
		System.out.println("Created Employee is "+emp);
		
	}

}
