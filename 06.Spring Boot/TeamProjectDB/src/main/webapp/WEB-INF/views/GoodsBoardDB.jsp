<%@page import="com.study.springboot.GoodsBoard.GoodsBoardDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	GoodsBoardDB goodsboardDB = GoodsBoardDB.getInstance();

	String BID = request.getParameter("BID");
	// BID(게시글번호)로 받아옴.
	System.out.println(BID);
	
	String returns = goodsboardDB.GoodsBoardDB();
	
    System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>