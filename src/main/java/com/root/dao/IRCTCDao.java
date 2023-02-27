package com.root.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.root.response.TicketResponse;

@Repository
public class IRCTCDao {

	Map<String, TicketResponse> ticketMap= new HashMap<>();
	
	public String saveTicket(TicketResponse response)
	{
		ticketMap.put(response.getPnr(), response);
		return response.getPnr();
	}
	
	public TicketResponse getTicket(String pnr)
	{
		if(ticketMap.containsKey(pnr))
		{
			return ticketMap.get(pnr);
		}
		return null;
	}
}
