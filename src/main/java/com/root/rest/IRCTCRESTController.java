package com.root.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.request.PassengerRequest;
import com.root.response.TicketResponse;
import com.root.service.IRCTCService;

@RestController
public class IRCTCRESTController {

	@Autowired
	private IRCTCService irctcservice;
	
	@PostMapping(value = "/bookTicket" , consumes = {"application/xml" , "application/json"})
	public ResponseEntity<String> bookTicket(@RequestBody PassengerRequest request)
	{
		String pnr = irctcservice.bookTicket(request);
		String msg = "Ticket Booked Successfully With PNR ::"+pnr;
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getTicket/{pnr}" , produces = {"application/xml" , "application/json"})
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String pnr)
	{
		TicketResponse ticket = irctcservice.getTicket(pnr);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
}
