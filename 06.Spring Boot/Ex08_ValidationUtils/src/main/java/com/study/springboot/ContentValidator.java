package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// 모든 요소를 검증할 필요는 없다. 필요한 필드만 검증하는 로직을 만들면 된다.

public class ContentValidator implements Validator
{
	@Override
	public boolean supports(Class<?> arg0) 
	{
		return ContentDto.class.isAssignableFrom(arg0);
		// 검증할 객체의 클래스 타입 정보
	}
	
	@Override
	public void validate(Object obj, Errors errors) 
	{
		ContentDto dto = (ContentDto)obj;
		
//		String sWriter = dto.getWriter();
//		if(sWriter == null || sWriter.trim().isEmpty()) 
//		{
//			System.out.println("Writer is null or empty");
//			errors.rejectValue("writer", "trouble");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "writer is empty.");
		//(errors, 두번째가 필드명, writer is empty)
		String sWriter = dto.getWriter();
		if (sWriter.length() < 3) 
		{
			errors.rejectValue("writer", "Writer is too short.");
		}
	
//		String sContent = dto.getContent();
//		if(sContent ==  null || sContent.trim().isEmpty()) 
//		{
//			System.out.println("Content is null or empty");
//			errors.rejectValue("content", "trouble");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content is empty.");
	}
	/* validator 메서드에서 Object obj를 파라미터로 받았는데, jsp의 Form의 input 필드의 name 이 obj 필드 이름과 같으면 dto의 모든 요소가 없더라도 상관 없다. */
	
}
