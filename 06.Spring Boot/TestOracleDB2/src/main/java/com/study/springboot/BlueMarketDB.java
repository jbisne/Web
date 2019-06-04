package com.study.springboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlueMarketDB {
	
    private static BlueMarketDB instance = new BlueMarketDB();

    public static BlueMarketDB getInstance() {
        return instance;
    }
    
    public BlueMarketDB() {  }

    // oracle 계정
    //String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String jdbcUrl = "jdbc:oracle:thin:@192.168.219.131:1521:xe";
    String userId = "scott";
    String userPw = "tiger";

    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    String sql = "";
    String sql2 = "";
    String returns = "";

    // 블루마켓DB
    public String BluemarketDB(String B_NICK, String B_PWD) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            
            sql = "SELECT B_NICK FROM TestDB WHERE B_NICK = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, B_NICK);
          //  pstmt.setString(2, B_PWD);
            
            rs = pstmt.executeQuery();           
            if(rs.next()) 
            {
            	returns = "이미 존재하는 아이디 입니다.";
            }
            else
            {
            	sql2="insert into TestDB VALUES(?,?)";
            	pstmt2 = conn.prepareStatement(sql2);
            	pstmt2.setString(1, B_NICK);
            	pstmt2.setString(2, B_PWD);
            	pstmt2.executeUpdate();          	
            	returns="succes!";
            	
//            	String nick = rs.getString("b_nick");
//            	String phone = rs.getString("b_phone");
//            	String address = rs.getString("b_address");
//            	String email = rs.getString("b_email");
//            	String image = rs.getString("b_image");
//            	 returns = nick + "|" + phone+ "|" + address+ "|" + email+ "|" + image;
            }

        } 
        catch (Exception e) 
        {		
        	e.printStackTrace();
        } 
        finally 
        {
        	if (pstmt2 != null)try {pstmt2.close();} catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null)try {conn.close();} catch (SQLException ex) {    }
        }
       
        return returns;
    }
    
}
