package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.ICardDao;
import com.study.springboot.dao.ITicketDao;

@Service
public class BuyCardTicketService implements IBuyCardTicketService
{
	@Autowired
	ICardDao card;
	@Autowired
	ITicketDao ticket;
	@Autowired
	TransactionTemplate transactionTemplate;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	@Transactional(propagation=Propagation.REQUIRED)
// 여길 번갈아 가면서 주석을 해체하고 테스트해보기.	
	
	@Override
	public void buyTicket(String consumerId, String countnum) 
	{
		try
		{
			transactionTemplate.execute(new TransactionCallbackWithoutResult() 
			{
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus arg0) 
				{
					card.payCard(consumerId, countnum);
					ticket.buyTicket(consumerId, countnum);
				}
			});
			
		}
		catch (Exception e)
		{
			System.out.println("[Transaction Propagation] Rollback 되었습니다.");
		}
	}
}
