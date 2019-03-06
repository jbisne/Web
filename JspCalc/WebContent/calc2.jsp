<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int result = 0;
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		String sNum1 = request.getParameter("num1");
		String sNum2 = request.getParameter("num2");
		String operator = request.getParameter("operation");
		
		int num1 = Integer.parseInt(sNum1);
	%>
</body>
</html>