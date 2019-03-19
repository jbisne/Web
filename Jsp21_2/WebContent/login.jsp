<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if (session.getAttribute("ValidMem") != null){  %>
	<jsp:forward page="main.jsp"></jsp:forward>
<% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="http://code.jquery.com/jquery.js"></script>
<script>
	function form_check() {
		if($('#id').val().length == 0) {
			alert("아이디를 입력해주세요.");
			$('#id').focus();
			return;
		}
		
		if($('#pw').val().length == 0) {
			alert("비밀번호를 입력해주세요.");
			$('#pw').focus();
			return;
		}
		submit_ajax();
	}
	
	function submit_ajax(){
		var queryString = $('#reg_frm').serialize();
		$.ajax({
			url: '/Jsp212/loginOk.jsp',
			type: 'POST',
			dataType: 'text',
			data: queryString,
			success: function (json) {
				//console.log(json);
				var result = JSON.parse(json);
				if (result.code=="success"){
					alert(result.desc);
					window.location.replace("main.jsp");
				} else {
					alert(result.desc);					
				}
			}
		});
	}
</script>
</head>
<body>
	<form id="reg_frm">
		아이디 : <input type="text" name="id" id="id" 
						value="<% if(session.getAttribute("id") != null)
									out.println(session.getAttribute("id"));
								%>"><br/>
		비밀번호 : <input type="password" name="pw" id="pw" size="20"><br/>
		<input type="button" value="로그인" onclick="form_check();">&nbsp;&nbsp;&nbsp;
		<input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'">
	</form>
</body>
</html>