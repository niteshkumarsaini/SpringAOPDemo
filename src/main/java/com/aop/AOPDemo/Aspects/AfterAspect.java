package com.aop.AOPDemo.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspect {

	@Pointcut(value = "execution(* com.aop.AOPDemo.ServicesImpl.EmployeeServiceImpl.getEmployee(..)) && args(empId)")
	private void logDisplayAdvice(int empId) {
		System.out.println("This is private Method before after advice.."); // will not execute
		/*
		 * The private method marked as @Pointcut will not execute during runtime
		 * because pointcut methods are only used for defining and matching join points.
		 * They are not meant to be invoked or executed directly during the
		 * application's flow.
		 */

	}

	@After("logDisplayAdvice(empId)")
	public void afterAdvice(JoinPoint jp, int empId) {
		System.out.println("This is empid " + empId);
		System.out.println("This advice is running after the " + jp.getSignature().getName() + " method ");
	}

}
