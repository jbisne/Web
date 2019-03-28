package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.dao.FDao;

public class FDeleteCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String fName = request.getParameter("fName");
		
		FDao dao = FDao.getInstance();
		dao.filedelete(fName);
	}
}
