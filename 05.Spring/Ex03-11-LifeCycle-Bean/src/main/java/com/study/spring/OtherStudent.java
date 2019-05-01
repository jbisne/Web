package com.study.spring;

import javax.annotation.*;

public class OtherStudent 
{
	private String name;
	private int age;
	
	public OtherStudent(String name, int age) 
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
	
	@PostConstruct
	public void initMethod() 
	{
		System.out.println("OtherStudent : initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod() 
	{
		System.out.println("OtherStudent : destroyMethod()");
	}
}
