package com.study.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.study.jsp.command.BPageInfo;
import com.study.jsp.dto.BDto;

public class BDao 
{
	//private static BDao instance = new BDao();
	DataSource dataSource;
	
	int listCount = 5;		//한 페이지당 보여줄 게시물의 갯수
	int pageCount = 5;		// 하단에 보여줄 페이지 리스트의 갯수
	
	public BDao()
	{
		try
		{
			// lookup 함수의 파라메터는 context.xml에 설정된
			// name(jdbc/Oracle11g)과 동일해야 한다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}				
	}
	
	public static BDao instance = new BDao();
	public static BDao getInstance()
	{
		return instance;
		//프라이빗을 퍼블릭스태틱 으로 : 싱글턴 패턴
	}
	
	public void write(int bCategory, String bName, String bTitle, String bContent)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = dataSource.getConnection();
			String query = "insert into mvc_board" +
						   "(bCategory, bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent)" +
						   "values " +
						   "(?, mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bCategory);
			pstmt.setString(2, bName);
			pstmt.setString(3, bTitle);
			pstmt.setString(4, bContent);
			int rn = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}		
	
	public ArrayList<BDto> list(int curPage, int boardCategory)
	{
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;		
//		System.out.println("리스트카테고리 : " + Category);
//		System.out.println("start: " + nStart + " end : " + nEnd);
		
		try
		{
			con = dataSource.getConnection();
			
			String query = "select * from( " +
						   "select rownum num, A.* from( " +
						   "select * from( " +
						   "select * from mvc_board where bcategory=?) " +
						   "order by bgroup desc, bstep asc) A " +
						   "where rownum <= ?) B where b.num >= ? ";
			
//			String query = "select * " +
//			   " from(" +
//			   "  select rownum num, A.* " +
//			   "    from(" + 
//			   "     select * " +
//			   "      from mvc_board where bCategory = ?" +
//			   "      order by bgroup desc, bstep asc) A " +
//			   "      where rownum <= ?) B " + 
//			   " where b.num >= ?";
			System.out.println("here");
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardCategory);
			pstmt.setInt(2, nEnd);
			pstmt.setInt(3, nStart);
			resultSet = pstmt.executeQuery();
			System.out.println("here2");
			
			
			while (resultSet.next())
			{
				System.out.println("here3");
				int bCategory = resultSet.getInt("bCategory");
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				System.out.println("here4");
				
				BDto dto = new BDto(bCategory, bId, bName, bTitle, bContent, bDate,
									bHit, bGroup, bStep, bIndent);
				
				dtos.add(dto);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public BDto contentView(String strID, String kind)
	{
		if(kind.equals("view"))
		{
			upHit(strID);
		}
		BDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try
		{
			con = dataSource.getConnection();
			
			String query = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,  Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next())
			{
				int bCategory = resultSet.getInt("bCategory");
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				 dto = new BDto(bCategory, bId, bName, bTitle, bContent, bDate,
									bHit, bGroup, bStep, bIndent);
				

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void modify (String bId, String bTitle, String bContent)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String query = "update mvc_board " +
						" set bTitle = ?, " +
						"	 bContent = ? " +
						" where bId = ?";
		//여기랑 밑에 트라이문에서 왜 bName을 지운거???
		try
		{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setString(3, bId);
			int rn = pstmt.executeUpdate();			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	private void upHit(String bId)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = dataSource.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bId);
			
			int rn = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(String bId)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String query = "delete from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			int rn = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	public BDto reply_view(String str)
	{
		BDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try
		{
			con = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(str));
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next())
			{
				int bCategory = resultSet.getInt("bCategory");
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new BDto(bCategory, bId, bName, bTitle, bContent, bDate,
							   bHit, bGroup, bStep, bIndent);				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void reply (String bCategory, String bId, String bName, String bTitle, 
						String bContent, String bGroup, String bStep, String bIndent)
	{
		replyShape(bGroup, bStep);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = dataSource.getConnection();
			String query = "insert into mvc_board " +
						   " (bCategory, bId, bName, bTitle, bContent, bGroup, bStep, bIndent) " +
						   " values (?, mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(bCategory));
			pstmt.setString(2, bName);
			pstmt.setString(3, bTitle);
			pstmt.setString(4, bContent);
			pstmt.setInt(5, Integer.parseInt(bGroup));
			pstmt.setInt(6, Integer.parseInt(bStep) + 1);
			pstmt.setInt(7, Integer.parseInt(bIndent) + 1);
			
			int rn = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if ( con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}							
		}
	}
	private void replyShape (String strGroup, String strStep)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = dataSource.getConnection();
			String query = "update mvc_board " +
						   "   set bStep = bStep + 1 " +
						   " where bGroup = ? and bStep > ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));
			
			int rn = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null) pstmt.close();
				if ( con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}							
		}
	}
	public BPageInfo articlePage(int curPage, int boardCategory)
	{
		/*왜 Dao에서 list.jsp처럼 게시판 페이지 형태를 잡아주었냐?
		여기는 데이터베이스에서 값을 갖고오는 모든걸 모아논곳.
		다른데서 만들면, 데이터값을 어디서받아와서 만들꺼? 그렇기 때문에
		데이터값도 받아오면서 형태를 잡아주고, 밑에 배열에
		값을 넣어주는것*/
		
		System.out.println("아티클");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		int listCount = 5;		// 한페이지당 보여줄 게시물의 갯수
		int pageCount = 5;		// 하단에 보여줄 페이지 리스트의 갯수
		
		//총 게시물의 갯수
		int totalCount = 0;
		try
		{
			con = dataSource.getConnection();
			
			String query = "select count(*) as total from ("
						   + "select * from mvc_board where bCategory = ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardCategory);
			//이거 무슨뜻?
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next())
			{
				totalCount = resultSet.getInt("total");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (resultSet != null) resultSet.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		
		// 총 페이지 수
		int totalPage = totalCount / listCount;
		if (totalCount % listCount > 0)
			totalPage++;
		
		// 현재 페이지
		int myCurPage = curPage;
		if (myCurPage > totalPage)
			myCurPage = totalPage;
		if (myCurPage < 1)
			myCurPage = 1;
		
		// 시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
		
		// 끝 페이지
		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage)
			endPage = totalPage;
		
		BPageInfo pinfo = new BPageInfo();
		pinfo.setBoardCategory(boardCategory);
		pinfo.setTotalCount(totalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(curPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);
		
		return pinfo;
	}
}
