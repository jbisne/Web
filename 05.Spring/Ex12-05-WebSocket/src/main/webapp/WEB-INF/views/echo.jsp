<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Echo</title>
<!-- 파일 다운받아서 연결하는방법. 나는 cdn으로 연결햇뜸.
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
-->
<script src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() 
	{
		$('#sendBtn').click(function() { sendMessage(); });
	});
	
	var wsocket;
	function sendMessage()
	{
		wsocket = new WebSocket("ws://localhost:8081/spring/echo-ws");
		// spring이 원래 예제에서는 wsocket이였다.
		// 컨텍스트 루트를 바꿔준것.
		// 컨텍스트루트는 별다른 지정안해주면 패키지명의 맨 마지막명으로 설정됨
		// (지금 나같은경우는 com.study.spring이니까 spring)
		// 프로퍼티-웹 프로젝트 셋팅-에서 컨텍스트루트를 바꿀수있다.
		// 루트바꿔줄경우 여기서도 같이 바꿔줘야함.
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
		wsocket.onopen = function() 
		{
			wsocket.send( $("#message").val() );
		};
	}
	function onMessage(evt)
	{
		var data = evt.data;
		alert("서버에서 데이터 받음 : " + data);
		wsocket.close();
	}
	function onClose(evt)
	{
		alert("연결 끊김");
	}
	
</script>
</head>
<body>
	<input type="text" id="message">
	<input type="button" id="sendBtn" value="전송">
</body>
</html>