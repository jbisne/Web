package com.study.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String myHelloSpring(Model model) 
	{
		String myMessage = "SPRING + BootStrap";
		
		model.addAttribute("message", myMessage);
		
		return "hellospring";
	}
	
}
