package com.study.springboot;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController 
{
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception 
	{
		return "Valid Annotation (3)";
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
				System.out.println("1:" +result.getFieldError("writer").getCode());
			}
			if (result.getFieldError("content") != null) 
			{
				System.out.println("2:" +result.getFieldError("content").getCode());
			}
			
			page = "createPage";
			
		}	
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) 
	{
		binder.setValidator(new ContentValidator());
	}
	
/*	
   	검증에 사용할 클래스를 initBinder 에서 의존성 주입을 한다.
	검증할 데이터는 28라인에서와 같이 앞에 @Valid 만 붙여 주면 된다. 
	33, 34 라인이 필요 없어 진다.
*/
}
