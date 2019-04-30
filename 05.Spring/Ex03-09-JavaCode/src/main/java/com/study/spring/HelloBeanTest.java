package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest
{
	public static void main(String[] args) 
	{
		// 1.Ioc 컨테이너 생성
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		
		// 컨테이너 생성은 다음과 같이도 가능
		// 1.Ioc 컨테이너 생성
//		ApplicationContext context =
//				new AnnotationConfigApplicationContext(Config.class);
//		이 경우 context.close(); 주석 처리!
		
		// 2.Hello Bean 가져오기
		Hello helloA = (Hello)context.getBean("hello");
		helloA.print();
		
		// 3.Hello Bean 가져오기
		Hello helloB = (Hello)context.getBean("hello1");
		helloB.print();
		
		// 4. PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		helloA.setPrinter(printer);
		helloA.print();

		// 5.싱글톤인지 확인
		System.out.println(helloA == helloB);
		
		context.close();
	}
}
//
// 실행 : Run as Java Application
// 얘는 웹이 아니고 앱이기 때문
