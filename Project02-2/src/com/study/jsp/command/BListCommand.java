package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.dao.BDao;
import com.study.jsp.dto.BDto;

public class BListCommand implements BCommand 
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
		
		String bCategory = request.getParameter("bCategory");
		int boardCategory = Integer.parseInt(request.getParameter("bCategory"));
		System.out.println("리스트 커맨드" + nPage + ":" + boardCategory);
		
		BDao dao = BDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage, boardCategory);
		//여기 왜?
		request.setAttribute("page", pinfo);
		
		nPage = pinfo.getCurPage();
		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);
		
		ArrayList<BDto> dtos = dao.list(nPage, boardCategory);
		request.setAttribute("list", dtos);
		session.setAttribute("bCategory", bCategory);
		//이 3줄 잘모르겠다.
	}
}
