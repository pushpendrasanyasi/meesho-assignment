package com.meesho.microservices.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.meesho.microservice.mail.MailService;
import com.meesho.microservices.entities.GenericMessage;

@Path("sendmailnotification")
public class MailController {

	@POST
	@Path("new")
	@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendMail(GenericMessage msg){
		//TODO should add - dependency injection through Spring 
		MailService ms = new MailService();
		ms.sendNotification(msg);
	}
	
}
