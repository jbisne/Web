package com.study.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean
{
	private String name;
	private int age;
	
	public Student(String name, int age) 
	{
		this.name = name;
		this.age = age;
	}
	/* set이 필요없다는게 아니라 생성자로 뿌려주기 때문에, 굳이 안써도되서
	   예제에서는 딱 이것만 필수다, 하는것만 적어줌 */
	
	public String getName() 
	{
		return name;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("Student : afterPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception
	{
		System.out.println("Student : destroy()");
	}
}