package com.root.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketResponse {

	private String ticketId;
	private String status;
	private String cost;
	private String from;
	private String to;
	private String pnr;
	private String jdate;
	private String name;
}
