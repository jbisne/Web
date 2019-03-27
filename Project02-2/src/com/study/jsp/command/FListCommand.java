package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.dao.FDao;
import com.study.jsp.dto.BDto;
import com.study.jsp.dto.FDto;

public class FListCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		int nPage = 1;
		try
		{
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		}
		catch (Exception e)
		{
			
		}
		
		FDao dao = FDao.getInstance();
		FPageInfo finfo = dao.articlePage(nPage);
		request.setAttribute("fInfo", finfo);
		System.out.println("진행O");
		
		nPage = finfo.getCurPage(); 
		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cPage", nPage);
		
		ArrayList<FDto> dtos = dao.list(nPage);
		request.setAttribute("list", dtos);
		
		System.out.println("list O");
		
	}
}
