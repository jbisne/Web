package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest 
{
	public static void main(String[] args ) 
	{
		String configLocation = "classpath:beans.xml";
		
		// 1.Ioc 컨테이너 생성
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(configLocation);
		
		// 2.Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		
		// 3.PrinterB Bean 가져오기
//		Printer printer = context.getBean("printerB", Printer.class);
//		hello.setPrinter(printer);
//		hello.print();
		// beans에서 기본 설정으로 A를 해둔것.
		// 3번은 A로설정된걸 B로 바꿔주는 과정.
		
		context.close();
	}
}
