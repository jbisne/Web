package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteOk implements Service 
{
    public deleteOk() 
    {
       
    }
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("delete ok");
		
		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		
		dto.setId(id);
		dto.setName(name);
		dto.setPw(request.getParameter("pw"));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		int ri = dao.deleteMember(dto);
		
		if(ri == 1)	
		{
			System.out.println("탈퇴 성공");
			//html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language=\"javascript\">");
			writer.println("	alert(\"회원 탈퇴 성공.\");");
			writer.println("	document.location.href=\"login.jsp\";");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();

		}
		else 
		{
			//html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language=\"javascript\">");
			writer.println("	alert(\"회원 탈퇴 실패.\");");
			writer.println("	document.location.href=\"delete.jsp\";");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();

		}
	}
}