<%@page import = "java.sql.DriverManager" %>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "java.sql.Statement" %>
<%@page import = "java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	Connection connection;
 	    Statement statement;	
     	ResultSet resultSet;
     	
     	String driver = "oracle.jdbc.driver.OracleDriver";
     	String url = "jdbc:oracle:thin:@localhost:1521:xe";
     	String uid = "scott";
     	String upw = "tiger";
     	String query = "select * from member";
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url,uid,upw);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				
				out.println("아이디 : " + id +
							", 비밀번호 : " + pw +
							", 이름 : " + name + 
							", 전화번호 : " + phone + "<br>");						
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try
			{
				if(resultSet != null) resultSet.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			}
			catch(Exception e) {}
		}
	%>
</body>
</html>

// ?물음표 쓴다는건 prepare쓴다는것
//화면이 필요한것jsp 동작만해주는것은 서블릿으로
//회원인지 알아보려면 count써서 1이면 회원 0이면 비회원
//모든페이지에 session을 체크해주는 로직이 들어가야함(수시로)