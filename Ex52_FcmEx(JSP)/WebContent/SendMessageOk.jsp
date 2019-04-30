<!-- 회사에서 푸시를 보낼수있는 사람이 드뭄.
	 할줄 알면 메리트가 크다. -->
<%@ page import= "java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.OutputStreamWriter" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %>

<%! 
	String ApiKey = "AIzaSyDMZznYNpyLZumBCTtIVMKhh_KWkWRbMVg";
	String fcmURL = "http://fcm.googleapis.com/fcm/send";	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	String notiTitle = request.getParameter("notiTitle");
	String notiBody = request.getParameter("notiBody");
	String msg = request.getParameter("message");
	
	try
	{
		// 데이터베이스에 저장된 토큰을 가져와 ArrayList에 저장합니다.
		String deviceId1 = "c2DFRx5rd54:APA91bGmrNxMDHCup7mqy3mMWyjlWoNUOONYQjoj3ZYxDqjiC-nPElgCOvDj88ldtq3W5q7ANG1lsq0It_2pH2XdrJcev7B0Ch1ogII8aqOPe-P1QFmfLocaz5AHafsNAln_p8U0IogX";
		String deviceId2 = "다른 사람 아이디";
		
		JSONArray deviceId = new JSONArray();
		deviceId.add(deviceId1);
		deviceId.add(deviceId2);
		
		URL url = new URL(fcmURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + ApiKey);
		conn.setRequestProperty("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		
		JSONObject noti = new JSONObject();
		noti.put("title", notiTitle);	//Notification title
		noti.put("body", notiBody);		//Notification
		
		JSONObject data = new JSONObject();
		data.put("message", msg);		//Data - message:value
		
		//json.put("to", deviceId);		// 한 명에게 보낼 때
		json.put("registration_ids", deviceId);	// 여러명에게 보낼 때
		json.put("notification", noti);
		json.put("data", data);
		//System.out.println(json.toString());
		
		try
		{
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
					
			String output;
			System.out.println("Output from Server ... \n");
			while ((output = br.readLine()) != null) 
			{
				System.out.println(output);
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		out.print(notiTitle + "<br>");
		out.print(notiBody + "<br>");
		out.print("Firebase Clout Message 가 발송되었습니다.");
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
%>
</body>
</html>