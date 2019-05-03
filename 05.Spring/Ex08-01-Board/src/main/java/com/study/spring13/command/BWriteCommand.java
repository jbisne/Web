package com.study.spring13.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.study.spring13.dao.BDao;

public class BWriteCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, Model model)
	{
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		//BDao dao = BDao.getInstance();
		//dao.write(bName, bTitle, bContent);
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
		//밑에 두줄 이걸로 써도 됨. 그럼 getInstance()사용X
	}
}


