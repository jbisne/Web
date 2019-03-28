<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table width= "500" cellpadding="0" cellspacing= "0" border= "1">	
		<form action="write.do" method= "post">
			<td> 카테고리 </td>
			<td>
			<select name="bCategory">
				<!-- <option value="">게시판 선택</option> 
				여유되면 이거선택하고 (입력)하면 alert창 뜨면서
				"게시판을 선택해주세요" 뜨면서 페이지 안넘어가게-->
			    <option value="0">공지 게시판</option>
			    <option value="1">자유 게시판</option>		
			</select>
			</td>
			
			<tr>
				<td> 회원 아이디 </td>
				<td><%if(session.getAttribute("id") != null)
                         out.println(session.getAttribute("id"));%></td>			               
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
				<td colspan= "2">
					<input type="submit" value="입력"> &nbsp;&nbsp;				
					<a href="list.do?bCategory=<%=session.getAttribute("bCategory")%>">목록으로</a>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>