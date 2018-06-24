package com.meesho.microservice;

import com.meesho.microservices.entities.GenericMessage;

public interface NotificationService {
	
	public void sendNotification(GenericMessage msg);
}
