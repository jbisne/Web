<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 25-2</title>
</head>
<body>
	<!-- 얘는 협업할땐 불편하지만, 소스관리할땐 편리하다. -->
	
	<a href = "insert.do">insert</a>
	<hr />
	<a href = "http://localhost:8081<%=request.getContextPath()%>/update.do">update</a>
	<hr />
	<a href = "http://localhost:8081/Jsp251/select.do">select</a>
	<hr />
	<a href = "<%=request.getContextPath()%>/delete.do">delete</a>

</body>
</html>
