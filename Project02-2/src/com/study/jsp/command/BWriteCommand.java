package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.dao.BDao;

public class BWriteCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String bCategory = request.getParameter("bCategory");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		//BDao dao = BDao.getInstance();
		//dao.write(bName, bTitle, bContent);
		
		BDao dao = new BDao();
		dao.write(bCategory, bName, bTitle, bContent);
		//밑에 두줄 이걸로 써도 됨. 그럼 getInstance()사용X
	}
}


