package com.study.springboot;

/*
	이 예제에서는 35라인, 38라인에서 getDefaultMessage() 메서드로 에러 메시지를 출력한다.

	이번 예제에서는 ContentDto.java 에서 어노테이션으로 제약사항을 지정하였기 때문에
	별도의 Validator 클래스가 필요하지 않고, initBinder를 사용할 필요가 없다.
 */
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController 
{
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception 
	{
		return "Valid Annotation (4)";
	}
	
	@RequestMapping("/insertForm")
	public String insert1() 
	{
		return "createPage";
	}
	
	@RequestMapping("/create")
	public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto,
								BindingResult result)
	{
		String page = "createDonePage";

//		ContentValidator validator = new ContentValidator();
//		validator.validate(contentDto, result);
		if(result.hasErrors()) 
		{
			if (result.getFieldError("writer") != null) 
			{
				System.out.println("1:" +result.getFieldError("writer").getDefaultMessage());
			}
			if (result.getFieldError("content") != null) 
			{
				System.out.println("2:" +result.getFieldError("content").getDefaultMessage());
			}
			
			page = "createPage";
			
		}	
		return page;
	}
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) 
//	{
//		binder.setValidator(new ContentValidator());
//	}

}
