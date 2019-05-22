<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td> 번호 </td>
				<td> 이름 </td>
				<td> 제목 </td>
				<td> 날짜 </td>
				<td> 조회수 </td>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td> 
					<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
					<a href="content_view?bId=${dto.bId}&kind=view">${dto.bTitle}</a></td>
				<td>${dto.bDate}</td>
				<td>${dto.bHit}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5"> <a href="write_view">글작성</a> </td>
			</tr>
			
			<tr>
				<td colspan="5"> 검색 </td>
			</tr>
	</table>	
</body>
</html>