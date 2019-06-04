<%@page import="com.study.springboot.BlueMarketDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	BlueMarketDB bluemarketDB = BlueMarketDB.getInstance();

	String nick = request.getParameter("B_NICK");
	String pwd = request.getParameter("B_PWD");
	System.out.println(nick);
	
	String returns = bluemarketDB.BluemarketDB(nick, pwd);
	
    System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>