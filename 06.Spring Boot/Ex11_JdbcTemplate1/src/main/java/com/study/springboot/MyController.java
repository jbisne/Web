package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController 
{
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception
	{
		return "jdbcTemplate 사용하기";
	}
	
	//@PostMapping("/user")
//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	public String userAdd(UserDTO user) 
//	{
//		userDao.insert(user);
//		return "redirect:/user";
//	}
//	insert문 아직 추가X
	
	//@getMapping("/user")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userlistPage(Model model) 
	{
		model.addAttribute("users", userDao.listForBeanPropertyRowMapper());
		return "/userlist";
	}
}
