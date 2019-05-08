package com.study.spring01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {
	
	@RequestMapping(value = "/myhome", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) 
	{		
		model.addAttribute("name", "orange" );
		
		return "orange";
	}
	
}