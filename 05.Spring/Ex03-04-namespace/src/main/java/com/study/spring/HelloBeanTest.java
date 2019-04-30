package com.study.spring;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest
{
	public static void main(String[] args) 
	{
		// beans.xml을 사용 안할 때 기존에 만들던 방법
		// "의존성이 강한 결합" 이라 부른다.
		// private이면 의존성강한결합은 에러가 나온다.
//		Printer p1 = new PrinterA();
//		Printer p2 = new PrinterB();
//		Hello h1 = new Hello();
//		h1.setName("이순신");
//		h1.setNickname("성웅");
//		h1.setPrinter(p1);
//		h1.print();
		
		String configLocation = "classpath:beans.xml";
		
		// 1.IoC 컨테이너 생성
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext(configLocation);
		
		// 2.Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		hello.print();
		
		// 3. PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);
		hello.setPrinter(printer);
		hello.print();
		
		// 4.싱글톤인지 확인
		// 싱글톤이란?
		// 어플리케이션에서 쓰이는것 하나만 만들어서 돌려쓰는것.
		Hello hello2 = context.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
		
		context.close();
	}
}
//
// 실행 : Run as Java Application
// 얘는 웹이 아니고 앱이기 때문
