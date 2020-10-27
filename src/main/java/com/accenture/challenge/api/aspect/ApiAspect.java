package com.accenture.challenge.api.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.accenture.challenge.api.exceptions.CustomNotFoundException;
import com.accenture.challenge.api.exceptions.ProxyException;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ApiAspect {

	@Pointcut("execution(public * com.accenture.challenge.api.controller..*(..))")
	public void controllerMethods() {}
	
	@After("controllerMethods()")
	public void advice(JoinPoint jp) {
		
		log.info("AOP : Se ejecuta el metodo " + jp.getSignature().getName() + " de la clase " + jp.getTarget());
		
	}
	
	
	@AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
	public void afterThrowing(JoinPoint jp, ProxyException exception) {
		log.info("AOP : Error en el metodo " + jp.getSignature().getName() + " de la clase " + jp.getTarget() + " : error : " + exception);
	}
	
	@AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
	public void afterThrowing(JoinPoint jp, CustomNotFoundException exception) {
		log.info("AOP : Error en el metodo " + jp.getSignature().getName() + " de la clase " + jp.getTarget() + " : error : " + exception);
	}
}
