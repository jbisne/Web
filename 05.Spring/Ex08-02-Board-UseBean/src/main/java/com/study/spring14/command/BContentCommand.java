package com.study.spring14.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.study.spring14.dao.BDao;
import com.study.spring14.dto.BDto;

//빈으로 등록하기 위해 어노테이션 지정
//별칭도 지정

@Component("contentHandler")
public class BContentCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, Model model)
	{
		String bId = request.getParameter("bId");
		String bkind = request.getParameter("kind");
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId, bkind);
		
		model.addAttribute("content_view", dto);
	}
    
}
