package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.dao.BDao;

public class BWriteCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		int bCategory = Integer.parseInt(request.getParameter("bCategory"));
		HttpSession session = request.getSession();
		// ★위에 두줄이 BWriteCommand에서 session사용의 핵심이다!★
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = BDao.getInstance();
		dao.write(bCategory, bName, bTitle, bContent);
		session.setAttribute("bCategory", request.getParameter("bCategory"));
		
		//BDao dao = new BDao();
		//dao.write(bName, bTitle, bContent);
		//밑에 두줄 이걸로 써도 됨. 그럼 getInstance()사용X
	}
}


