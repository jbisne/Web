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
	
	<table width= "700px" cellpadding="5" cellspacing= "5" border= "5">
		<form action="fileUpload.jsp" method= "post" enctype= "multipart/form-data">
			<tr>
				<td> 회원 아이디 </td>
				<td><input type= "text" name= "bName" size= "20">&nbsp;( <%if(session.getAttribute("id") != null)
                         out.println(session.getAttribute("id"));%>)</td>			               
			</tr>
			
			<tr>
				<td> 제목 </td>
				<td> <input type= "text" name= "bTitle" size= "50"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea name= "bContent" rows= "10"></textarea></td>
			</tr>
			<tr>
				<td> 파일 </td>
				<td><input type= "file" name= "filename"></td>
			</tr>
			<tr>
				<td><input type="submit" value="업로드" ></td>
			</tr>
		</form>
	</table>
	
</body>
</html>
