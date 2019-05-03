package com.study.spring.gm;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class GuestMessageController 
{
//	@RequestMapping(value = "/list.json")
//	@ResponseBody
//	public List<GuestMessage> listJson()
//	{
//		System.out.println("aaaaaaa");
//		List<GuestMessage> messages = Arrays.asList(
//				new GuestMessage(1, "메시지", new Date()),
//				new GuestMessage(2, "메시지", new Date())
//				);
//			
//		return messages;
//	}
	
	@RequestMapping(value = "/list.json")
	@ResponseBody
	public GuestMessageJSONList listJson()
	{
		return getMessageJsonList();
	}
	
	private GuestMessageJSONList getMessageJsonList() 
	{
		System.out.println("aaaaaaa");
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage(1, "메시지", new Date()),
				new GuestMessage(2, "메시지", new Date())
				);
			
		return new GuestMessageJSONList(messages);
	}

}
