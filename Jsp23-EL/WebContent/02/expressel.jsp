<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id= "member" class= "com.study.jsp.MemberInfo" scope= "page" />
<jsp:setProperty name="member" property= "name" value= "모모" />
<jsp:setProperty name="member" property= "id" value= "momo" />
<jsp:setProperty name="member" property= "pw" value= "123" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 23-2</title>
</head>
<body>
	이름 : <jsp:getProperty name="member" property= "name" /><br>
	아이디 : <jsp:getProperty name="member" property= "id" /><br>
	비밀번호 : <jsp:getProperty name="member" property= "pw" /><br>
	
	<hr>
	<!-- 가장 많이 쓰일 예제. 이렇게 제일 많이 쓴다. -->
	<!-- member.name=전우치 는 세터다. 값을넣어주는.
		 member.name 은 게터. -->
	이름 : ${ member.name= "모모"}<br>
		 
	이름 : ${ member.name }<br>
	아이디 : ${ member.id }<br>
	비밀번호 : ${ member.pw }<br>
</body>
</html>