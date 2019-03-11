package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginOk implements Service
{
 
    public loginOk() 
    {
       
    }

    @Override
	public void execute(HttpServletRequest request,
						HttpServletResponse response)
				throws ServletException, IOException
	{
    	System.out.println("loginOk");
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		MemberDto dto = new MemberDto();
		MemberDao dao = MemberDao.getInstance();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		int checkNum = dao.userCheck(id, pw);
		
		if(checkNum != -1)
		{
			//html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language=\"javascript\">");
			writer.println("	alert(\"로그인 정보가 틀렸습니다.\");");
			writer.println("	history.go(-1);");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
		else if(checkNum == 1)
		{
			// html 출력
			writer.println("<html><head></head><body>");
			writer.println("<script language=\"javascript\">");
			writer.println("	alert(\"로그인되었습니다.\");");
			writer.println("	document.location.href=\"main.jsp\";");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
			
			// 콘솔창 출력(내가 확인하기위해서)
			// String name = dto.getName();말고
			// session.setAttribute("name", name);에서 뒤에 name에 
			// dto.getName()으로 적어도 된다.
			dto = dao.getMember(id);			
			String name = dto.getName();
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
			System.out.println("로그인 성공");
		}

	}

}
