package com.study.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.spring.dto.TicketDto;

public class TicketDao 
{
	JdbcTemplate template;
	
//	PlatformTransactionManager transactionManager;
	TransactionTemplate transactionTemplate;
	
	public void setTemplate(JdbcTemplate template) 
	{
		this.template = template;
	}
	
//	public void setTransactionManager(PlatformTransactionManager transactionManager) 
//	{
//		this.transactionManager = transactionManager;
//	}
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) 
	{
		this.transactionTemplate = transactionTemplate;
	}
	
	public TicketDao() 
	{
		System.out.println(template);
	}
	
	public void buyTicket(final TicketDto dto) 
	{
		try 
		{
			transactionTemplate.execute(new TransactionCallbackWithoutResult() 
			{
				@Override
				public void doInTransactionWithoutResult(TransactionStatus arg0 )
				{		
					template.update(new PreparedStatementCreator() 
					{
						@Override
						public PreparedStatement createPreparedStatement(Connection con)
								throws SQLException
						{
							String query = "insert into card (consumerId, amount) values (?, ?)";
							PreparedStatement pstmt = con.prepareStatement(query);
							pstmt.setString(1, dto.getConsumerId());
							pstmt.setString(2, dto.getAmount());
							
							return pstmt;
						}
					});
					
					template.update(new PreparedStatementCreator() 
					{
						@Override
						public PreparedStatement createPreparedStatement(Connection con)
								throws SQLException
						{
							String query = "insert into ticket (consumerId, countnum) values (?, ?)";
							PreparedStatement pstmt = con.prepareStatement(query);
							pstmt.setString(1, dto.getConsumerId());
							pstmt.setString(2, dto.getAmount());
							
							return pstmt;
						}
					});
				}
			});
		}		
		catch (Exception e) 
		{
			System.out.println("Rollback 되었습니다.");
		}
	}
}
