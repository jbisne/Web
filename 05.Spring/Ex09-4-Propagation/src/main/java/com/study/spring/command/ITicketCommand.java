package com.study.spring.command;

import com.study.spring.dto.TicketDto;

public interface ITicketCommand 
{
	public void execute(TicketDto dicketDto);
}
