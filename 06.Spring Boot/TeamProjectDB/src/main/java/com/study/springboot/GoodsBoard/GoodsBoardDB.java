package com.study.springboot.GoodsBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GoodsBoardDB 
{
    private static GoodsBoardDB instance = new GoodsBoardDB();

    public static GoodsBoardDB getInstance() 
    {
        return instance;
    }
    
    public GoodsBoardDB() {  }

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
    
    // 상품정보DB
    public String GoodsBoardDB() 
    {
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            
            sql = "SELECT * FROM GOODSBOARD";
            pstmt = conn.prepareStatement(sql);
           
            rs = pstmt.executeQuery();
            JSONArray arr = new JSONArray();
            while(rs.next()) 
            {
            JSONObject obj = new JSONObject();
            obj.put("BID",rs.getString("BID"));		//게시글 번호
        	obj.put("BHIT",rs.getString("BHIT"));	//조회수		
        	obj.put("BCOST",rs.getString("BCOST")); //물건가격
        	obj.put("BTITLE",rs.getString("BTITLE"));	//제목
        	obj.put("BNAME",rs.getString("BNAME"));		//닉네임
        	obj.put("BCONTENT",rs.getString("BCONTENT"));	//설명or내용
        	obj.put("BLOCATION",rs.getString("BLOCATION")); //주소(위치)-희망거래지역
        	obj.put("BXLOC",rs.getString("BXLOC"));		//위치 X좌표
        	obj.put("BYLOC",rs.getString("BYLOC"));		//위치 Y좌표
        	obj.put("BIMAGE1",rs.getString("BIMAGE1")); //저장된 이미지명1
        	obj.put("BTHUMBIMG1",rs.getString("BTHUMBIMG1")); //저장된 썸네일 이미지명
        	obj.put("BIMAGE2",rs.getString("BIMAGE2"));	//저장된 이미지명2
        	obj.put("BIMAGE3",rs.getString("BIMAGE3")); //저장된 이미지명3
        	obj.put("BIMAGE4",rs.getString("BIMAGE4")); //저장된 이미지명4
        	obj.put("BDATE",rs.getString("BDATE"));		//게시날짜
        	obj.put("BCATEGORY",rs.getString("BCATEGORY"));	//게시판 분류
        	obj.put("BPOSITION",rs.getString("BPOSITION")); //물품 카테고리
        	obj.put("BQRCODE",rs.getString("BQRCODE"));		//QR코드
        	obj.put("BTRADEOK",rs.getString("BTRADEOK"));	//판매상태(판매중/예약중/완료)
        	obj.put("BPRODUCT",rs.getString("BPRODUCT"));		//물품상태(0.새것, 1.중고, 2.낡음)
        	obj.put("BREPLYCOUNT",rs.getString("BREPLYCOUNT"));		//후기갯수
        	obj.put("BCOMMENTCOUNT",rs.getString("BCOMMENTCOUNT"));	//댓글갯수
        	obj.put("BREPORTCOUNT",rs.getString("BREPORTCOUNT"));	//신고횟수
        	
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