package com.cs.testapplication.orderbooks.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SerivceLogingAspect {

	@Around(value = "com.cs.testapplication.orderbooks")
	public Object log(ProceedingJoinPoint joinPoint){
		// TODO
		return null;
	}
	
}
