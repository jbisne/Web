package com.study.springboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;





public class BlueMarketDB 
{

    private static BlueMarketDB instance = new BlueMarketDB();

    public static BlueMarketDB getInstance() 
    {
        return instance;
    }
    
    public BlueMarketDB() {  }

    // oracle 계정
    //String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    String jdbcUrl = "jdbc:oracle:thin:@192.168.219.112:1521:xe";
    String userId = "scott";
    String userPw = "tiger";

    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    String sql = "";
    JSONObject returns = new JSONObject();
    JSONArray arr = new JSONArray();
    
    // 블루마켓DB
    public String BluemarketDB() 
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            
            sql = "SELECT * FROM BLUEMARKETUSER";
            pstmt = conn.prepareStatement(sql);
           
            rs = pstmt.executeQuery();
            JSONArray arr = new JSONArray();
            while(rs.next()) 
            {
            JSONObject obj = new JSONObject();
            obj.put("B_NICK",rs.getString("B_NICK"));
        	obj.put("B_PHONE",rs.getString("B_PHONE"));
        	obj.put("B_ADDRESS",rs.getString("B_ADDRESS"));
        	obj.put("B_EMAIL",rs.getString("B_EMAIL"));
        	obj.put("B_IMAGE",rs.getString("B_IMAGE"));

            arr.add(obj);

            }
            
            returns.put("returns", arr);
        } 
        catch (Exception e) 
        {	
        	e.printStackTrace();
        } 
        
        finally 
        {
	     	if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	        if (conn != null)try {conn.close();} catch (SQLException ex) {}
        }
        
        return returns.toJSONString();
    }
    
}