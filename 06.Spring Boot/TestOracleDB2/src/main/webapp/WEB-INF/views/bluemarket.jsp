<%@page import="com.study.springboot.BlueMarketDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	BlueMarketDB bluemarketDB = BlueMarketDB.getInstance();

	String B_NICK = request.getParameter("B_NICK");
	System.out.println(B_NICK);
	
	String returns = bluemarketDB.BluemarketDB();
	
    System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>