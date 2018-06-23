package com.meesho.jms.entities;

import java.io.Serializable;
import java.util.HashMap;

public class GenericBrokerMessage implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -9081112733765876595L;
	
	private GenericMessageType type;
	private HashMap<String,String> messageAttributes;
	
	public GenericBrokerMessage() {
		this.messageAttributes = new HashMap<String,String>();
	}
	
	public GenericMessageType getType() {
		return type;
	}

	public void setType(GenericMessageType type) {
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
