<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
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
		
		int num1= Integer.parseInt(sNum1);
		int num2= Integer.parseInt(sNum2);
		
		//int로 바꿔준 이유는 String 형태로 더해주면 값 계산이 안되고,
		// 5 + 5 는 55 이렇게 되기때문에 String 형태를 int형태로 바꿔준것!
		
		if (operator.equals("add"))
		{
			result = num1 + num2;
			out.println("두 수의 더하기는" + result);
		}
		
		else if(operator.equals("minus"))
		{
			result = num1 - num2;
			out.println("두 수의 빼기는" + result);
		}
		
		else if(operator.equals("multiply"))
		{
			result = num1 * num2;
			out.println("두 수의 곱하기는" + result);
		}
		
		else if(operator.equals("divide"))
		{
			result = num1 / num2;
			out.println("두 수의 나누기는" + result);
		}

	%>
<br>
결과는 <%= result %> 입니다.
<br>
<br>
<a href = "form.html">다시 계산하기</a>
</body>
</html>