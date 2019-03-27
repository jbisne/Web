package com.study.jsp.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.command.BCommand;
import com.study.jsp.command.BContentCommand;
import com.study.jsp.command.BDeleteCommand;
import com.study.jsp.command.BListCommand;
import com.study.jsp.command.BModifyCommand;
import com.study.jsp.command.BReplyCommand;
import com.study.jsp.command.BReplyViewCommand;
import com.study.jsp.command.BWriteCommand;
import com.study.jsp.command.FContentCommand;
import com.study.jsp.command.FDeleteCommand;
import com.study.jsp.command.FListCommand;
import com.study.jsp.login.Service;
import com.study.jsp.login.deleteOk;
import com.study.jsp.login.joinOk;
import com.study.jsp.login.loginOk;
import com.study.jsp.login.modifyOk;


@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BFrontController() {
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
		request.setCharacterEncoding("UTF-8");
		System.out.println("actionDo");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();		
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());		
		
		HttpSession session = null;
		session = request.getSession();
		int curPage = 1;
		if(session.getAttribute("cpage") != null)
		{
			curPage = (int)session.getAttribute("cpage");
		}
		if(session.getAttribute("fpage") != null)
		{
			curPage = (int)session.getAttribute("fpage");
		}

//////////////////////////////////////////////////////////
		
		if(com.equals("/loginOk.do")) {
			Service service = new loginOk();
			service.execute(request, response);
		}else if(com.equals("/modifyOk.do")) {
			Service service = new modifyOk();
			service.execute(request, response);
		}else if(com.equals("/joinOk.do")) {
			Service service = new joinOk();
			service.execute(request, response);
		}else if(com.equals("/deleteOk.do")) {
			Service service = new deleteOk();
			service.execute(request, response);
		}else if(com.equals("/logoutOk.do")) {
			logoutOk(request, response);
		}


		
		if (com.equals("/write_view.do")) 
		{
			viewPage = "write_view.jsp";
		}
		else if (com.equals("/write.do"))
		{
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if (com.equals("/list.do"))
		{
			command = new BListCommand();
			command.execute(request,response);
			viewPage = "list.jsp";
		}
		else if (com.equals("/content_view.do"))
		{
			command = new BContentCommand();
			command.execute(request,  response);
			viewPage = "content_view.jsp";
		}
		else if  (com.equals("/modify_view.do"))
		{
			command = new BContentCommand();
			command.execute(request,  response);
			viewPage = "modify_view.jsp";
		}
		else if (com.equals("/modify.do"))
		{
			command = new BModifyCommand();
			command.execute(request, response);
			
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}
		else if (com.equals("/delete.do"))
		{
			command = new BDeleteCommand();
			command.execute(request,  response);
			viewPage = "list.do";
		}
		else if (com.equals("/reply_view.do"))
		{
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		}
		else if (com.equals("/reply.do"))
		{
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
/////////////////////////////////////////////////////
		else if(com.contentEquals("/filelist.do"))
		{
			command = new FListCommand();
			command.execute(request, response);
			viewPage = "filelist.jsp";
		}
		else if(com.contentEquals("/fileUpload_view.do"))
		{
			viewPage = "fileUpload_view.jsp";
		}
		else if(com.contentEquals("/filecontent_view.do"))
		{
			command = new FContentCommand();
			command.execute(request, response);
			viewPage = "filecontent_view.jsp";
		}
		else if(com.contentEquals("/filedelete.do"))
		{
			command = new FDeleteCommand();
			command.execute(request, response);
			viewPage = "filelist.do?page="+curPage;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
	public void logoutOk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("logout");
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
	
}
