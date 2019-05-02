package com.study.spring05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring05.member.Member;

@Controller
public class HomeController 
{	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) 
	{
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmId";
	}
	
	@RequestMapping("/board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) 
	{
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		return "board/checkId";
	}
	
	//  http://localhost:8081/spring05/member/join1?name=1&id=2&pw=3&email=4
	// join1은 join2와는 다르게 파라미터에 값을 넣어서 체크해줘야함
	@RequestMapping("/member/join1")
	public String joinData(@RequestParam("name") String name, 
						   @RequestParam("id") String id,
						   @RequestParam("pw") String pw, 
						   @RequestParam("email") String email, 
						   Model model) 
	{
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		
		model.addAttribute("memberInfo", member);
		
		return "member/join1";
	}
	
	// 위의 코드를 아래처럼 줄여서 쓸수있다.
	// 단, 파라미터 갯수는 맞춰줘야한다.
	
	@RequestMapping("/member/join2")
	public String joinData(Member member) 
	{
		return"member/join2";
	}
}
