<%@page import = "com.study.jsp.MemberDTO" %>
<%@page import = "com.study.jsp.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 20-2</title>
</head>
<body>
	<%
		try
		{
			MemberDAO memberDAO = new MemberDAO();
			
			MemberDTO dto = new MemberDTO();
			
			dto.setId("momo");
			dto.setPw("123");
			dto.setName("모모");
			dto.setPhone("010-1234-5678");
			dto.setGender("woman");
			int nResult = memberDAO.memberInsert(dto);
			
			dto.setId("sana");
			dto.setPw("123");
			dto.setName("사나");
			dto.setPhone("010-1234-5678");
			dto.setGender("woman");
			nResult = memberDAO.memberInsert(dto);
			
			dto.setId("mina");
			dto.setPw("123");
			dto.setName("미나");
			dto.setPhone("010-1234-5678");
			dto.setGender("woman");
			nResult = memberDAO.memberInsert(dto);
			
			out.println("insert success");
		}
		catch (Exception e)
		{
			
		}
	%>
	
	<br />
	<a href = "memberSelect.jsp">회원정보 보기</a>
	
</body>
</html>