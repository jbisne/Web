package com.study.spring15.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring15.command.BCommand;
import com.study.spring15.command.BListCommand;
import com.study.spring15.util.Constant;

// @Autowired 어노테이션에 의해 자동으로 설정 파일에 연결된다.
// @Autowired 자동으로 빈즈를 불러온다.
// BListCommand 는 별칭이 없으므로 클래스 이름으로 연결한다.


@Controller
public class BController 
{	
	@Autowired
	private ApplicationContext context;
	
	BCommand command = null;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) 
	{
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) 
	{
		System.out.println("list()");
		command = new BListCommand();
		command.execute(request, model);
		
		return "list";
	}
	
}
