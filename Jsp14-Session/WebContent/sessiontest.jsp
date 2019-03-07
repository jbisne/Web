<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 14-2</title>
</head>
<body>
	
	<%	
	//처음에만 아이디가 있나 비교하고,
	//그다음부턴 세션에 아이디가있나 확인해서 있으면 로그인페이지로 보냄.
		request.setCharacterEncoding("UTF-8");
	
		Enumeration enumeration = session.getAttributeNames();
		int i = 0;
		while(enumeration.hasMoreElements())
		{
			i++;
			
			String sName = enumeration.nextElement().toString();
			String sValue = (String)session.getAttribute(sName);
			
			out.println(sName + " : " +sValue + "<br>");
		}
		
		if(i == 0)
			out.println("해당 세션이 삭제 되었습니다.");
	%>
	
</body>
</html>