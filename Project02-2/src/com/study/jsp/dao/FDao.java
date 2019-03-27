package com.study.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.study.jsp.command.BPageInfo;
import com.study.jsp.command.FPageInfo;
import com.study.jsp.dto.BDto;
import com.study.jsp.dto.FDto;

public class FDao
{
	DataSource dataSource;
	
	int listCount = 5;		//한 페이지당 보여줄 게시물의 갯수
	int pageCount = 5;		// 하단에 보여줄 페이지 리스트의 갯수
	
	public FDao()
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
	
	public static FDao instance = new FDao();
	public static FDao getInstance()
	{
		return instance;
		//프라이빗을 퍼블릭스태틱 으로 : 싱글턴 패턴
	}
	
	public FPageInfo articlePage(int curPage)
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
			
			String query = "select count(*) as total from file_board";
			pstmt = con.prepareStatement(query);
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
		
		FPageInfo finfo = new FPageInfo();
		finfo.setTotalCount(totalCount);
		finfo.setListCount(listCount);
		finfo.setTotalPage(totalPage);
		finfo.setCurPage(curPage);
		finfo.setPageCount(pageCount);
		finfo.setStartPage(startPage);
		finfo.setEndPage(endPage);
		
		return finfo;
	}
	
	public ArrayList<FDto> list(int curPage)
	{
		ArrayList<FDto> dtos = new ArrayList<FDto>();
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

			String query = "select * " +
						   " from(" +
						   "  select rownum num, A.* " +
						   "    from(" + 
						   "     select * " +
						   "      from file_board " +
						   "      order by fId desc) A " +
						   "      where rownum <= ?) B " + 
						   " where b.num >= ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, nEnd);
			pstmt.setInt(2, nStart);
			// pstmt.setInt뜻, 왜 nEnd먼저 쓰는지
			resultSet = pstmt.executeQuery();			
			
			while (resultSet.next())
			{
				int fId = resultSet.getInt("fId");
				String fName = resultSet.getString("fName");
				String fTitle = resultSet.getString("fTitle");
				String fContent = resultSet.getString("fContent");
				String fileName = resultSet.getString("fileName");
				String orgfileName = resultSet.getString("orgfileName");
				Timestamp fDate = resultSet.getTimestamp("fDate");
				int fHit = resultSet.getInt("fHit");
				
				FDto dto = new FDto(fId, fName, fTitle, fContent, fileName, 
									orgfileName, fDate, fHit);
				
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
	
	public void insertFile(String fName, String fTitle, String fContent,
							String fileName, String orgfileName)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "insert into file_board " +
					   " (fId, fName, fTitle, fContent, fileName, orgfileName, fDate, fHit) " +
					   " values " +
					   " (file_board_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		try
		{
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fName);
			pstmt.setString(2, fTitle);
			pstmt.setString(3, fContent);
			pstmt.setString(4, fileName);
			pstmt.setString(5, orgfileName);
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(7, 0);
			int rn = pstmt.executeUpdate();
			System.out.println("insertcount : " + rn);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e2) 
			{
				e2.printStackTrace();
			}
		}		
	}
	
	public FDto filecontentView(String fileID, String kind)
	{
		if(kind.equals("view"))
		{
			upHit(fileID);
		}
		FDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try
		{
			con = dataSource.getConnection();
			
			String query = "select * from file_board where fId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(fileID));
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next())
			{
				int fId = resultSet.getInt("fId");
				String fName = resultSet.getString("fName");
				String fTitle = resultSet.getString("fTitle");
				String fContent = resultSet.getString("fContent");
				String fileName = resultSet.getString("fileName");
				String orgfileName = resultSet.getString("orgfileName");
				Timestamp fDate = resultSet.getTimestamp("fDate");
				int fHit = resultSet.getInt("fHit");
				
				 dto = new FDto(fId, fName, fTitle, fContent, fileName,
						 		orgfileName, fDate,	fHit);
				 System.out.println("filecontent dao진행");
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
	
	private void upHit(String fId)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			con = dataSource.getConnection();
			String query = "update file_board set fHit = fHit + 1 where fId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fId);
			
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
	
	public void filedelete(String fId)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String query = "delete from file_board where fId = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fId);
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
}
