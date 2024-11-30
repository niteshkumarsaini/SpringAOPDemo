package com.aop.AOPDemo.Aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.aop.AOPDemo.Model.Employee;

@Aspect
@Component
public class BeforeAspect {
	
	//Running this before advice before get all employees
	@Before(value = "execution(* com.aop.AOPDemo.ServicesImpl.EmployeeServiceImpl.getAllEmployees())")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("This advice is running before the "+jp.getSignature().getName()+"  method");
		System.out.println("Before Advice Run Successful");

	}
	
	

}
