package com.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop 
{
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
}
// advice 지시자 around에 의해 포인트컷 앞뒤로 기능을 추가할 수 있다.