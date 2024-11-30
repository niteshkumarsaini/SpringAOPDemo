package com.aop.AOPDemo.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect                                 
@Component
public class AroundAspect {
	
	@Around(value = "execution(* com.aop.AOPDemo.ServicesImpl.EmployeeServiceImpl.remove(..)) && args(empId)")
	public boolean AroundAspectAdvice(ProceedingJoinPoint jp,int empId) {
		System.out.print("This "+jp.getSignature().getName()+" method is executed for the confirmation that Employee is not deleted yet.");
		try {
			jp.proceed();
			System.out.println("This "+jp.getSignature().getName()+" method is executed to confirm that the Employee is now deleted successfully...");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
