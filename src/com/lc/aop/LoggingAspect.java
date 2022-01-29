package com.lc.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(* com.lc.controller.*.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable{
		
		String classname=pjp.getTarget().getClass().getName();
		String methodname=pjp.getSignature().getName();
		String arguments="";
		for(Object obj:pjp.getArgs()) {
			arguments=arguments+obj.toString();
		}
		
		
		
		logger.info("ENTER -- Class -> "+classname+" || Methodname -> "+methodname+" || Arguments -> "+arguments);
		Object obj=pjp.proceed();
		logger.info("EXIT -- Class -> "+classname+" || Methodname -> "+methodname+" || Return Value -> "+obj.toString());
		
		return obj;
	}
}
