<%@page import= "java.util.Enumeration" %>
<%@page import= "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import= "com.oreilly.servlet.MultipartRequest" %>
<%@page import= "com.study.jsp.dao.FDao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <% 	
 	String fName = (String)session.getAttribute("id");
 	// 이게 [게시판이름 fName]과 [로그인이름 id(나중에 혼자공부할때 mId로 만들기.)]이
 	// 같게 만들어주는 코드.
 	String fTitle = "";
 	String fContent = "";
 	String fileName = "";
 	String orgfileName = "";
 	
 	System.out.println("과정1");
 	// String uploadPath = request.getSession().getServletContext().getRealPath("/");
 	// String uploadPath = request.getRealPath("fileUpload"); 
 	// upload는 폴더명 / 폴더의 경로를 구해옴
 	String uploadPath = "D:/web/Project02-2/WebContent/fileFolder";
 	System.out.println(uploadPath);
 	
	 // String path = request.getRealPath("fileFolder");
	 // int size = 1024 * 1024 * 10;	//10M (곱하기니까 뒤에 *10은 앞으로써줘도 상관없다.)
	 // 원래 예제에서는 path,size 변수값 넣어줫었다.
 	
 	try
 	{
 		MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
 				request, 
				uploadPath, // 파일을 저장할 디렉토리 지정
				10 * 1024 *1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
				"utf-8", // 인코딩 방식 지정
				new DefaultFileRenamePolicy()); // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
 		
 		Enumeration files = multi.getFileNames();
 		String str = (String)files.nextElement();
 		
 		fTitle = multi.getParameter("fTitle");
 		fContent = multi.getParameter("fContent");

 		/* form의 <input type="file"> name값을 모를 경우 name을 구할때 사용
		Enumeration files=multi.getFileNames(); // form의 type="file" name을 구함
		String file1 =(String)files.nextElement(); // 첫번째 type="file"의 name 저장
		String file2 =(String)files.nextElement(); // 두번째 type="file"의 name 저장
		*/
		
		fileName = multi.getFilesystemName(str); 
		// name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
		orgfileName = multi.getOriginalFileName(str); 
		// name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
 	}
 	catch(Exception e)
 	{
 		e.printStackTrace();
 		// 업로드 종료
 	}
	 
 	FDao dao = FDao.getInstance(); 
	dao.insertFile(fName, fTitle, fContent, fileName, orgfileName);
		
 %>
	<script>
	alert("업로드 완료가 완료되었습니다.");
	window.location.replace("filelist.do");
	</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 파일 업로드 </title>
</head>
<body>

</body>
</html>