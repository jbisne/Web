package com.study.jsp;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class JoinProcess extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletExcetpion, IOException
	{
		request.setCharacerEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
		String address = request.getParameter("address");
	}
}
