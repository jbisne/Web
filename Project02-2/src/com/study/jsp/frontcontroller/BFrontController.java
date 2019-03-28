package com.study.jsp.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

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
		/* 나중에 다시 공부할 때, [멤버변수값 mId] [파일변수갑서 fId] 이렇게 알아보기 
		  쉽게 만들기 [게시판커맨드 bcommand] [멤버(로그인)커맨스 mcommand] 이렇게 */
		
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
////////////////////////////////////////////////////////////

		
		if (com.contentEquals("/write_view.do")) 
		{
			viewPage = "write_view.jsp";
		}
		else if (com.contentEquals("/write.do"))
		{
			command = new BWriteCommand();
			command.execute(request, response);

			//request.setAttribute("bCategory", session.getAttribute("bCategory"));
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			// 여기 밑에 세줄맞나?
		}
		else if (com.equals("/list.do"))
		{
			command = new BListCommand();
			command.execute(request,response);
			viewPage = "list.jsp";
		}
		else if (com.contentEquals("/content_view.do"))
		{
			command = new BContentCommand();
			command.execute(request,  response);
			viewPage = "content_view.jsp";
/////////////////////////////////////////////////////////			
		}else if(com.contentEquals("/modify_view.do")) {
			String id = (String)session.getAttribute("id");
			String name = request.getParameter("bName");
			System.out.println(id + name);
			if(id.equals(name)) {
				command = new BContentCommand();
				command.execute(request, response);
				viewPage = "modify_view.jsp";
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('권한없음');history.go(-1);</script>");		
				out.flush();
				return;
			}		
		}else if(com.contentEquals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do?page="+curPage;
		}

//////////////////////////////////////////////////////		
		else if(com.contentEquals("/delete.do")) 
		{
			String id = (String)session.getAttribute("id");
			String name = request.getParameter("bName");
			System.out.println(id + name);
	
			if(id.equals(name)) 
			{
				command = new BDeleteCommand();
				command.execute(request, response);
				String boardCategory = (String)session.getAttribute("bCategory");
				viewPage = "list.do?page="+curPage+"&bCategory="+boardCategory;
			}
			else 
			{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('권한없음');history.go(-1);</script>");		
				out.flush();
				return;
			}
		}
		else if (com.contentEquals("/reply_view.do"))
		{
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		}
		else if (com.contentEquals("/reply.do"))
		{
			command = new BReplyCommand();
			command.execute(request, response);
			String boardCategory = (String)session.getAttribute("bCategory");
			viewPage = "list.do?page="+curPage+"&bCategory="+boardCategory;
			//reply할때 이렇게 페이지 설정해주는게 핵심.
			//reply 뿐만아니라 모든 곳에 bCategory로 페이지 설정해줘야함
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
			String id = (String)session.getAttribute("id");
			String name = request.getParameter("fName");
			System.out.println(id + name);

			viewPage = "filelist.do?page="+curPage;
			
			if(id.equals(name)) 
			{
				command = new FDeleteCommand();
				command.execute(request, response);
				viewPage = "filelist.do?page="+curPage;
			}
			else 
			{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('권한없음');history.go(-1);</script>");		
				out.flush();
				return;
			}
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
