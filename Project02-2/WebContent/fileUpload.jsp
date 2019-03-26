<%@page import= "java.util.Enumeration" %>
<%@page import= "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import= "com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <% 	
 	String fName = (String)session.getAttribute("mId");
 	String fTitle = "";
 	String fContent = "";
 	String fileName = "";
 	String orgfileName = "";
 	
 	System.out.println("h");
 	// String uploadPath = request.getSession().getServletContext().getRealPath("/");
 	// String uploadPath = request.getRealPath("fileUpload"); 
 	// upload는 폴더명 / 폴더의 경로를 구해옴
 	String uploadPath = "D:/web/fileFolder";
 	System.out.println(uploadPath);
 	
 	try
 	{
 		
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 파일 업로드 </title>
</head>
<body>
	file upload success!
</body>
</html>