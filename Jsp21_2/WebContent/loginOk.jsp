<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp" %>
<%@page import="com.study.jsp.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.study.jsp.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	MemberDAO dao = MemberDAO.getInstance();
	
	String json_data = "";
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	int ri = dao.userCheck(id, pw);
	
	if(ri == MemberDAO.MEMBER_LOGIN_SUCCESS){
		session.setAttribute("id", id);
		session.setAttribute("name", pw);
		session.setAttribute("ValidMem", "yes");
		json_data = "{\"code\":\"success\",\"desc\":\"로그인 성공\"}";
	} 
	else if (ri == MemberDAO.MEMBER_LOGIN_PW_NO_GOOD ) {
			json_data = "{\"code\":\"fail\",\"desc\":\"비밀번호가 틀립니다.\"}";
		}
	else if (ri == MemberDAO.MEMBER_LOGIN_IS_NOT) {
			json_data ="{\"code\":\"fail\",\"desc\":\"존재하지 않는 아이디 입니다.\"}"; 
	}
	else {
			json_data =
			"{\"code\":\"fail\",\"desc\":\"에러가 발생하여 로그인에 실패했습니다.\"}";
		}
	
	response.setCharacterEncoding("UTF-8");
	out.println(json_data);
%>
