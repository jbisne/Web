<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>printNumbers1</title>
</head>
<body>

<% 
	for (int i =0; i<10; i++)
	{
		out.println(i + "<br>");
	}
	// 요점 두개
	// out을 사용하면 출력이된다.
	// jsp문서에서 <%안에서는 자바의 문법을 사용할수있다.
%>

</body>
</html>