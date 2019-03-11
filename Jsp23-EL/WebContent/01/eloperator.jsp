<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 23-1</title>
</head>
<body>
	<!-- 1>2"이면" 이 아니고 1이2보다 크다!라는뜻
		 그러면 결과는? false 이렇게 생각할것. -->
	<!-- ${ value } -->
	${ 1+2 } <br>
	${ 1-2 } <br>
	${ 1*2 } <br>
	${ 1/2 } <br>
	${ 1>2 } <br>
	${ 1<2 } <br>
	${ (1>2) ? 1 : 2 } <br>
	${ (1>2) || (1<2) } <br>
	
</body>
</html>