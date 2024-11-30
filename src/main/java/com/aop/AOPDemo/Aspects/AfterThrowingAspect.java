package com.aop.AOPDemo.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAspect {


	@AfterThrowing(value = "execution(* com.aop.AOPDemo.ServicesImpl.EmployeeServiceImpl.getEmployee(..)) && args(empId)",throwing ="ex")
	public void afterThrowingAdvice(JoinPoint jp, int empId,Exception ex) {
		System.out.println("Some Exception occurs "+ex.getMessage());
//		System.out.println("Excecuted After get single employee method");
		System.out.println("This is executed after "+jp.getSignature().getName());

	}
	
}
