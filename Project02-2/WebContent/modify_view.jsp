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
	
	<table width= "500" cellpadding= "0" cellspacing="0" border= "1">
		<form action= "modify.do"  name="modify_form" method= "post">
			<input type="hidden" name= "bId" value= "${content_view.bId}">
			<input type="hidden" name= "bName" value= "${content_view.bName}">
			<input type="hidden" name= "kind" value= "modify">
			<input type="hidden" name= "bCategory" value=<%=session.getAttribute("bCategory")%>>
		
			<tr>
				<td> 카테고리 </td>
				<td>${content_view.bCategory }</td>
			<tr>
				<td> 번호 </td>
				<td> ${content_view.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${content_view.bHit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> ${content_view.bName}</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type= "text" name= "bTitle" value= "${content_view.bTitle}"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td>
					 <textarea rows="10" name="bContent" id="ir1" cols="100" >${content_view.bContent} </textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan= "2"> 
					<input type= "submit" value= "수정"> &nbsp;&nbsp;
					<a href="list.do?page=<%=session.getAttribute("cpage")%>&bCategory=<%=session.getAttribute("bCategory")%>">목록보기</a>&nbsp;&nbsp;
				</td>
			</tr>
		</form>
	</table>
	
</body>
</html>