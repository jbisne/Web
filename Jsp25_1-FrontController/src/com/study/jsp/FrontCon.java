package com.study.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
//*.do -> 확장자를 do를쓰는애를 전부 불러와
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontCon() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		System.out.println("uri : " +uri);
		String conPath = request.getRequestURI();
		System.out.println("conPath : " +conPath);
		String command = request.getRequestURI();
		System.out.println("command : " +command);
		
		if (command.contentEquals("/insert.do"))
		{
			System.out.println("insert");
			System.out.println("------------");		
		}
		else if (command.equals("/update.do"))
		{
			System.out.println("update");
			System.out.println("------------");
		}
		else if (command.contentEquals("/select.do"))
		{
			System.out.println("select");
			System.out.println("------------");
		}
		else if (command.contentEquals("/delete.do"))
		{
			System.out.println("delete");
			System.out.println("------------");
		}
		
	}
}
