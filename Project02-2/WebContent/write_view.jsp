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
			    <option value="0">공지 게시판</option>
			    <option value="1">자유 게시판</option>		
			</select>
			</td>
			
			<tr>
				<td> 회원 아이디 </td>
				<td><%if(session.getAttribute("id") != null)
                         out.println(session.getAttribute("id"));%></td>			               
			</tr>
			<!-- 내가 하려던 [글적을때마다 아이디](로그인ID) 하려면, 오라클 테이블에
				새로적는 아이디값이 들어갈 칼럼이 한칸 더 있어야한다. 왜냐하면 
				나중에 로그인or수정할 때 뭘 보고 비교해서 글 수정하게 해줄지말지 정하지. -->
			
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