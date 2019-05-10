<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<%
	out.println("#04 : Hello World");
%>
	<br>
	당신의 아이디는 ${studentId} 입니다.<br>
	당신의 이름은 ${name} 입니다.
	
	<!-- 
	예제에서는 ${id}로 되어있는데, 제대로 나오게하려면 MyController에서 써준
	키값인  ${studentId} 로 해줘야한다. name은 똑같이 name으로 해줫으니
	똑같이 출력되는것.
	-->
</body>
</html>