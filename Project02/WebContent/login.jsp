<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://code.jquery.com/jquery.js"></script>
    
    <script src="https://apis.google.com/js/platform.js" async defer></script>
	<meta name="google-signin-client_id" content="196552721056-dubj28468hv8e4g978v9l0590bkh3j6l.apps.googleusercontent.com">

	<script>
		function onSignIn(googleUser) 
		{
			var profile = googleUser.getBasicProfile();
			console.log('ID: ' + profile.getId());
			console.log('Name: ' + profile.getName());
			console.log('Image URL: ' + profile.getImageUrl());
			console.log('Email: ' + profile.getEmail());
	
			$('#login').css('display', 'none');
	    	$('#logout').css('display', 'block');
	    	$('#upic').attr('src', profile.getImageUrl());
	    	$('#uname').html('[ ' +profile.getName() + ' ]');
	    	
		}
		
		function signOut() 
		{
		    var auth2 = gapi.auth2.getAuthInstance();
		    auth2.signOut().then(function () 
		    {
		    	console.log('User signed out.');
		    
		    	$('#login').css('display', 'block');
		    	$('#logout').css('display', 'none');
		    	$('#upic').attr('src', '');
		    	$('#uname').html('');
		    });
		}	
	</script>
	
</head>
<body>

	<form action="loginOk.do" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="text" name="pw"><br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입"
				onclick="javascript:window.location='join.jsp'">
	
	<!-- =============로그인 창=============== -->
		
	<div id="login" class="g-signin2" data-onsuccess="onSignIn"></div>

	<div id="logout" style="display: none;">
    <input type="button" onclick="signOut();" value="로그아웃" /><br>

    <img id="upic" src=""><br>
    <span id="uname"></span>
	</div>
	<!-- =============구글 로그인 창(login1사용)=============== -->
	</form><br>
</body>
</html>

