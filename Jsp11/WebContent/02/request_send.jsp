<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 11-2</title>
</head>
<body>
	<%!
		int age;
		//전역변수(어디에 넣어도 되는 변수로 이해)
	%>
	
	<%
		String str = request.getParameter("age");
		age = Integer.parseInt(str);
		
		if(age >= 20)
		{
			response.sendRedirect("pass.jsp?age=" + age);
		}
		else
		{
			response.sendRedirect("ng.jsp?age=" + age);
		}
	%>
	
	<%= age %>
	
</body>
</html>