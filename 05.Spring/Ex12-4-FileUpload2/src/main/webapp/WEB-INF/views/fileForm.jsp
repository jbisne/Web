<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 22-2</title>
</head>
<body>	
<!-- 텍스트가 올라가는부분,파일이 올라가는부분이 있어서 파트가
두개로 나눠졋다고해서 멀티파트 enctype. -->
<!-- 스트림으로 올라가기떄문에 타입 post사용 -->	
	
	<form action="fileFormOk" method= "post" enctype= "multipart/form-data">
		파일 : <input type= "file" name= "filename"><br />
		<input type= "submit" name= "File Upload"> 	
	</form>
	
</body>
</html>
