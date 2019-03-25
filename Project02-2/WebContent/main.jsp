<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("ValidMem") == null){

	}
	
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<h1> 로그인 메인페이지 </h1>
	<form action="logout.jsp" method="post">
		<input type="submit" value="로그아웃">&nbsp;&nbsp;&nbsp;
		<input type="button" value="정보수정"
				onclick="javascript:window.location='modify.jsp'">&nbsp;&nbsp;&nbsp;
		<input type="button" value="회원탈퇴"
				onclick="javascript:window.location='delete.jsp'">
		<input type="button" value="공지사항" onclick=<%session.setAttribute("bCategory", 0);%>
		"javascript:window.location='list.do?bCategory=0'">
		<input type="button" value="자유게시판" onclick=<%session.setAttribute("bCategory", 1);%>
		"javascript:window.location='list.do?bCategory=1'">
		<input type="button" value="자료실"	onclick=>
		<input type="button" value="채팅"
				onclick="javascript:window.location='Chatlogin.jsp'">&nbsp;&nbsp;&nbsp;
	</form>
	
</body>
</html>