// MyBatis의 특징
// 자바코드 대신에 xml 을 이용하여 데이터를 다룰 수 있게 한 것

package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.IMyUserDao;

@Controller
public class MyController 
{
	@Autowired
	private IMyUserDao userDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception
	{
		return "MyBatis 사용하기";
	}

	@RequestMapping("/user")
	public String userlistPage(Model model) 
	{
		model.addAttribute("users", userDao.getUser());
		return "userlist";
	}
}