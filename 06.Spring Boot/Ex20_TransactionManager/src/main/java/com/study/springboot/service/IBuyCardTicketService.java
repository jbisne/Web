/*  다음 서비스는 카드로 티켓을 구매하는 비지니스 로직을 구현한 예이다.
	카드 결제에 대한 DAO 호출
	티켓 구매에 대한 DAO 호출
	다른 비지니스 로직을 추가한다면 현금으로 티켓을 구해하는 예를 추가할 수도 있다. */

package com.study.springboot.service;

public interface IBuyCardTicketService
{
	public void buyTicket(String consumerId, String countnum);
}
