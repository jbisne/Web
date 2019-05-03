package com.study.spring13.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring13.command.BCommand;
import com.study.spring13.command.BContentCommand;
import com.study.spring13.command.BDeleteCommand;
import com.study.spring13.command.BListCommand;
import com.study.spring13.command.BModifyCommand;
import com.study.spring13.command.BReplyCommand;
import com.study.spring13.command.BReplyViewCommand;
import com.study.spring13.command.BWriteCommand;

//@Autowired 어노테이션에 의해 자동으로 설정 파일에 연결된다.
//BListCommand 는 별칭이 없으므로 클래스 이름으로 연결한다.

@Controller
public class BController 
{
	BCommand command = null;
	
	@RequestMapping("/write_view")
	public String write_view(HttpServletRequest request, Model model) 
	{
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) 
	{
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(request, model);

		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) 
	{
		System.out.println("list()");
		command = new BListCommand();
		command.execute(request, model);
		
		return "list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) 
	{
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(request, model);
		
		return "content_view";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) 
	{
		command = new BContentCommand();
		command.execute(request, model);
		
		return "modify_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) 
	{
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(request, model);
		
		command = new BContentCommand();
		command.execute(request, model);

		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) 
	{
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(request, model);		
		
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) 
	{	
		model.addAttribute("request", request);
		command = new BReplyViewCommand();
		command.execute(request, model);
		
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) 
	{
		model.addAttribute("request", request);
		command = new BReplyCommand();
		command.execute(request, model);

		return "redirect:list";
	}
	
}
