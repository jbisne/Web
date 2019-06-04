<%@page import="com.study.springboot.SitterDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	SitterDB sitterDB = SitterDB.getInstance();

	String S_ID = request.getParameter("S_ID");
	//String S_CONTEXT = request.getParameter("S_CONTEXT");
	//String S_HIT = request.getParameter("S_HIT");
	//String S_IMAGE = request.getParameter("S_IMAGE");
	System.out.println(S_ID);
	
	String returns = sitterDB.petsitterDB(S_ID);
	
    System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>