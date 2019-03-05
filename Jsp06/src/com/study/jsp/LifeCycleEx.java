package com.study.jsp;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycleEx extends HttpServlet {

    public LifeCycleEx() 
    {
        super();
        System.out.println("생성");
    }

	public void init() 
			throws ServletException 
	{
		System.out.println("init");
	}

	public void destroy() 
	{
		System.out.println("destroy");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("doPost");
	}
	
	@PostConstruct
	private void aaa()
	{
		System.out.println("생성자 호출 직후 불림");
	}
	
	@PreDestroy
	private void bbb()
	{
		System.out.println("디스트로이 호출 전에 불림");
	}
}
// @->지시자, 얘한테 의미가 있는것.
// void옆에 있는 이름보다 @붙은 애가 중요함.
