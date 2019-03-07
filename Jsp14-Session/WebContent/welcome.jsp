<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 14-2</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");

		Object obj1 = session.getAttribute("id");
		//Object인 이유는 그냥 하나의 객체일뿐이라서.
		
		String sId = (String)obj1;
		//스트링형태로 변환 필요.
		
		if(sId == null)
		{
			response.sendRedirect("login.html");
		}
		else
		{
			out.println(sId + "님 안녕하세요." + "<br>");
		}
	%>
	<br><p>
	
	<a href= "logout.jsp">로그아웃</a>
	
	<a href= "cookietest.jsp">쿠키 테스트</a>
	
</body>
</html>