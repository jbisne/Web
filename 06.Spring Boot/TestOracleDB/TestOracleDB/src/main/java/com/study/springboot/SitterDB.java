package com.study.springboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SitterDB {
	
    private static SitterDB instance = new SitterDB();

    public static SitterDB getInstance() {
        return instance;
    }
    
    public SitterDB() {  }

    // oracle 계정
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String userId = "scott";
    String userPw = "tiger";

    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    String sql = "";
    String returns = "A";
    
    //SitterDto sdto = new SitterDto();
    

    // 펫시터
    public String petsitterDB(String S_ID) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            
            sql = "SELECT S_NAME, S_CONTEXT, S_HIT, S_IMAGE, S_SEX FROM SITTER WHERE S_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, S_ID);
           
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	String name = rs.getString("s_name");
            	String context = rs.getString("s_context");
            	int hit = rs.getInt("s_hit");
            	String image = rs.getString("s_image");
            	String sex = rs.getString("s_sex");
            	returns = name + "|" + context+ "|" + hit+ "|" + image+ "|" + sex;
            }

        } catch (Exception e) {		
        			e.printStackTrace();
        		} finally {
     					if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
        				if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
        			}
        return returns;
    }
    
}
