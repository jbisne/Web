package com.study.spring03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController 
{
	@RequestMapping("/board/view")
	public String view() 
	{
		return "board/view";
	}
	
	@RequestMapping("/board/content")
	public String content(Model model) 
	{
		model.addAttribute("id", 30);
		return "board/content";
	}
	
	@RequestMapping("/board/reply")
	public ModelAndView reply() 
	{
		// 객체 자체를 리턴할수도 있다(모델도 세팅하고 뷰도 세팅하고)
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", 30);
		mv.setViewName("board/reply");
		
		return mv;
	}
}
