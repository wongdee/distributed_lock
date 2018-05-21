package com.wongdee.lock.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LockAspect {
	
	@Around("@annotation(lock)")
	public Object lock(ProceedingJoinPoint joinPoint, Lock lock) throws Throwable{
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		Method method = signature.getMethod();
		String name = method.getName();
		System.out.println(name.toLowerCase());
		Annotation[] annotations = method.getAnnotations();
		Parameter[] parameters = method.getParameters();
		
		Object proceed = joinPoint.proceed();
		
		return proceed;
	}
	
}
