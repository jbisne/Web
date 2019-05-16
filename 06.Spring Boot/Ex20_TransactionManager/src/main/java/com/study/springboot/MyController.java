// Service를 사용했을 때, 비즈니스 로직이 어떻게 바뀌는지 
// Spring Ex09_TransactionX랑 비교하면서 볼 것.
// Ex18은 Service를 사용하는 의미는없지만 과정을 보여준것. 여기서는 어떻게되는지 비교.

package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dto.CardDto;
import com.study.springboot.service.IBuyCardTicketService;

@Controller
public class MyController 
{
	@Autowired
	IBuyCardTicketService buyTicket;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception
	{
		return "Transaction X (1)";
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket()
	{
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(CardDto dto, Model model)
	{
		buyTicket.buyTicket(dto.getConsumerId(), dto.getAmount());
		
		model.addAttribute("dto", dto);
		
		return "buy_ticket_end";
	}
}
