package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.dao.FDao;

public class FDeleteCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String fId = request.getParameter("fId");
		
		FDao dao = FDao.getInstance();
		dao.filedelete(fId);
	}
}
