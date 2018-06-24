package com.meesho.microservices.entities;

import java.io.Serializable;
import java.util.HashMap;

public class GenericMessage implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -9081112733765876595L;
	
	private NotificationType type;
	private HashMap<String,String> messageAttributes;
	
	public GenericMessage() {
		this.messageAttributes = new HashMap<String,String>();
	}
	
	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public HashMap<String, String> getMessageAttributes() {
		return messageAttributes;
	}

	public void setMessageAttributes(HashMap<String, String> messageAttributes) {
		this.messageAttributes = messageAttributes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
