package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.dao.FDao;
import com.study.jsp.dto.FDto;

public class FContentCommand implements BCommand
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String fId = request.getParameter("fId");
		String bKind = request.getParameter("kind");
		FDao dao = FDao.getInstance();
		FDto dto = dao.filecontentView(fId, bKind);
		//FDto dto 지만 dao에서 값 불러오는거 헷갈리지말기!
		//여기서 틀려서 엄청 헤맷다!
		
		System.out.println("content 커맨드 진행");
		request.setAttribute("filecontent_view", dto);
	}
}
