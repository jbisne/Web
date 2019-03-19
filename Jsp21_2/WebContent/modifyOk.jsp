<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp" %>
<%@ page import="com.study.jsp.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.study.jsp.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	MemberDAO dao = MemberDAO.getInstance();
	String json_data = "";
	int ri = dao.updateMember(dto);
	if(ri == 1) {
			json_data = "{\"code\":\"success\",\"desc\":\"정보가 수정되었습니다.\"}";
	}
	else {
			json_data =
			"{\"code\":\"fail\",\"desc\":\"에러가 발생하여 정보수정을 실패했습니다.\"}";
	}
	
	response.setCharacterEncoding("UTF-8");
	out.println(json_data);	
%>
