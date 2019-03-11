<%@page import= "java.util.Enumeration" %>
<%@page import= "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import= "com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp jquery ajax file upload 구글에 얘네 쳐서
	 응용법 공부해볼것. 나만의 예제같은건 필요할때
	 검색해서 쓰는게아니라 미리 만들어놔야함.-->
 <% 	
 	String path = request.getRealPath("fileFolder");
 
 	int size = 1024 * 1024 * 10;	//10M
 	String file = "";
 	String oriFile = "";
 	
 	try
 	{
 		MultipartRequest multi = new MultipartRequest(request, path, size,
 									"UTF-8", new DefaultFileRenamePolicy());
 		
 		Enumeration files = multi.getFileNames();
 		String str = (String)files.nextElement();
 		
 		file = multi.getFilesystemName(str);
 		oriFile = multi.getOriginalFileName(str);
 	}
 	catch(Exception e)
 	{
 		e.printStackTrace();
 	}

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 22-2</title>
</head>
<body>
	file upload success!
</body>
</html>