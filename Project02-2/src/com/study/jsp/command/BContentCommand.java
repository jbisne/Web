package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.dao.BDao;
import com.study.jsp.dto.BDto;


public class BContentCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String bId = request.getParameter("bId");
		String bKind = request.getParameter("kind");
		BDao dao = BDao.getInstance();
		BDto dto = dao.contentView(bId, bKind);
		
		System.out.println("content커맨드 진행");
		request.setAttribute("content_view", dto);
	}
    

}
