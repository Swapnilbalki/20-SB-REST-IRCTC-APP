package com.root.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.dao.IRCTCDao;
import com.root.request.PassengerRequest;
import com.root.response.TicketResponse;

@Service
public class IRCTCService {

	@Autowired
	private IRCTCDao irctcdao;
	
	public String bookTicket(PassengerRequest request)
	{
		TicketResponse response = new TicketResponse();
		String id = UUID.randomUUID().toString();
		response.setTicketId(id);
		response.setName(request.getName());
		response.setFrom(request.getFrom());
		response.setTo(request.getTo());
		response.setJdate(request.getJdate());
		response.setCost("500");
		response.setStatus("CONFIRMED");
		String pnr = UUID.randomUUID().toString();
		response.setPnr(pnr);
		String pnr1 = irctcdao.saveTicket(response);
		
		return pnr1;
	}
	
	public TicketResponse getTicket(String pnr)
	{
		TicketResponse ticket = irctcdao.getTicket(pnr);
		return ticket;
	}
}
