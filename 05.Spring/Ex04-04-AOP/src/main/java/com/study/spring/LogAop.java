package com.study.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LogAop 
{
	// @Pointcut("execution(public void get*(..))")
	// public void인 모든 get 메소드
	
	// @Pointcut("execution(* com.study.spring.*.*())")
	// com.study.spring 패키지에 파라미터가 없는 모든 메소드
	
	// @Pointcut("execution(* com.study.spring..*.*())")
	// com.study.spring 패키지 & com.study.spring 하위 패키지에
	// 파라미터가 없는 모든 메소드
	
	// @Pointcut("execution(* com.study.spring.Worker.*())")
	// com.study.spring.Worker 안의 모든 메소드
	
	// @Pointcut("within(com.study.spring.*)")
	// com.study.spring 패키지 안에 있는 모든 메소드
	
	// @Pointcut("within(com.study.spring..*)")
	// com.study.spring 패키지 및 하위 패키지 안에 있는 모든 메소드
	
	// @Pointcut("within(com.study.spring.Worker)")
	// com.study.spring.Worker 모든 메소드
	
	// @Pointcut("bean(student)") // student 빈에만 적용
	// @Pointcut("bean(*ker)")	  // ~ker로 끝나는 빈에만 적용
	
	@Pointcut("within(com.study.spring.*)")
	private void poincutMethod() {}
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable
	{
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println( signatureStr + "is start.");
		
		long st = System.currentTimeMillis();
		
		try 
		{
			Object obj = joinpoint.proceed();
			return obj;
		}
		finally 
		{
			long et = System.currentTimeMillis();
			
			System.out.println( signatureStr + " if finished.");
			System.out.println( signatureStr + " 경과시간 : " +(et - st));
		}
	}
	
	@Before("within(com.study.spring.*)")
	public void beforeAdvice() 
	{
		System.out.println("beforeAdvice()");
	}
	
	public void beforeAdvice(JoinPoint joinPoint) 
	{
		System.out.println("beforeAdvice()");
	}
	
	public void afterReturningAdvice() 
	{
		System.out.println("afterReturningAdvice()");
	}
	
	public void afterThrowingAdvice() 
	{
		System.out.println("afterThrowingAdvice()");
	}
	
	public void afterAdvice() 
	{
		System.out.println("afterAdvice()");
	}
}
// advice 지시자 around에 의해 포인트컷 앞뒤로 기능을 추가할 수 있다.