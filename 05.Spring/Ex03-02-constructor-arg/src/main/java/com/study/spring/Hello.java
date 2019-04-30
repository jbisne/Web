package com.study.spring;

public class Hello 
{
	private String name;
	private String nickname;
	private Printer printer;
	
	public Hello(String name, String nickname, Printer printer) 
	{
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	// Ex03-01은 세터로 만들기. 2는 생성자로 만들기.

	public String sayHello() 
	{
		return "Hello " + name + " : " + nickname; 
	}
	
	public void print() 
	{
		printer.print(sayHello());
	}
}
