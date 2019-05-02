package com.study.spring04;

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
@RequestMapping("/board")
// 보통 두번째 컨트롤러에 붙여줌. 이렇게 해놓으면 무조건 시작할 때 
// /board가 붙어버리니까.
public class HomeController2 
{	
	//그냥 /board만 치면 얘가 나오고
	@RequestMapping("/")
	public String read(Model model) 
	{
		model.addAttribute("name", "홍길동");
		
		return "board/home";
	}
	
	// /board/write를 치면 얘가 나온다.
	@RequestMapping("/write")
	public String write(Model model) 
	{
		model.addAttribute("id", 30);
		
		return "board/write";
	}
	
}
