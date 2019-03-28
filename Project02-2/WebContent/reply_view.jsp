<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="./naver-editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	<script>
		function form_check()
		{
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			
			document.reply_form.submit();
		}
	</script>
</head>
<body>
	
	<table width= "500" cellpadding= "0" cellspacing="0" border= "1">
		<form action= "reply.do" name= "reply_form" method= "post">
			<input type="hidden" name= "bCategory" value= "${reply_view.bCategory}">
			<input type="hidden" name= "bId" value= "${reply_view.bId}">
			<input type="hidden" name= "bName" value= "${reply_view.bName}">
			<input type="hidden" name= "bGroup" value= "${reply_view.bGroup}">
			<input type="hidden" name= "bStep" value= "${reply_view.bStep}">
			<input type="hidden" name= "bIndent" value= "${reply_view.bIndent}">
			<input type="hidden" name= "kind" value= "modify">
		
			<tr>
				<td> 카테고리 </td>
				<td> ${reply_view.bCategory} </td>
			</tr>
			<tr>
				<td> 번호 </td>
				<td> ${reply_view.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${reply_view.bHit} </td>
			</tr>
			<tr>
				<td> 이름=본인아이디 </td>
				<td> ${reply_view.bName} </td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type= "text" name= "bTitle" value= "${reply_view.bTitle}"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td>
					 <textarea rows="10" name="bContent" >${reply_view.bContent} </textarea>
				</td>
			</tr>
			<tr>
				<td colspan= "2"> 
				<input type= "submit" value= "답변"> &nbsp;&nbsp;
				<a href= "content_view.do?bId=${reply_view.bId}&kind=modify">취소</a>&nbsp;&nbsp;
				<a href= "list.do?page=<%=session.getAttribute("cpage")%>" >목록</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>