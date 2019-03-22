<%@page import="java.sql.Connection" %>
<%@page import="com.study.jsp.login.MemberDto" %>
<%@page import="com.study.jsp.login.MemberDao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <%
   		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 탈퇴 </title>
</head>
<body>
	<form action="deleteOk.do" method="post">
		아이디 : <%= id %><br>
		비밀번호 : <input type="text" name="pw" size="20"><br>	
		이름 : <%= name %><br>
		
		<input type="submit" value="회원탈퇴">		
	</form>	
</body>
</html>