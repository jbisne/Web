package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController 
{
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "DBtest (1)";
	}
	
	@RequestMapping("/dbtest")
	public String welcom1() {		
		return "dbtest";
	}
	
	// 블루마켓 유저 목록
	@RequestMapping("/bluemarket")
	public String welcom2() {		
		return "bluemarket";
	}
}