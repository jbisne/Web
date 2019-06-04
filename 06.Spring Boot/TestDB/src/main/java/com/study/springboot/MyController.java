package com.study.springboot;

import org.springframework.web.bind.annotation.RequestMapping;

public class MyController 
{
	@RequestMapping("/android") 
	public void androidTest() 
	{ 
		System.out.println("ANDROID로 접근했습니다."); 
	}

}
