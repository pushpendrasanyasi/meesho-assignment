package com.meesho.microservices.entities;

import java.util.HashMap;

public class GenericNotificationObject {

	private String mailTo;
	private String mailFrom;
	
	// variable substitution need to be done on the message body
	private String messageBodyTemplateWithAttachement;
	
	// variable substitution need to be done on the message body
	private String messageBodyTemplateWithOutAttachement;
	
	private boolean sendWOAttachment;
	
	// variable pattern "$#variable_name#$"
	private String variablePattern;

	private MailAttachment[] attachments;
	private HashMap<String, String> messageBodyParamsMap;

	public GenericNotificationObject() {
		this.messageBodyParamsMap = new HashMap<String, String>();
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMessageBodyTemplate() {
		return messageBodyTemplateWithAttachement;
	}

	public void setMessageBodyTemplate(String messageBodyTemplate) {
		this.messageBodyTemplateWithAttachement = messageBodyTemplate;
	}

	public MailAttachment[] getAttachments() {
		return attachments;
	}

	public void setAttachments(MailAttachment[] attachments) {
		this.attachments = attachments;
	}

	public HashMap<String, String> getMessageBodyParamsMap() {
		return messageBodyParamsMap;
	}

	public void setMessageBodyParamsMap(HashMap<String, String> messageBodyParamsMap) {
		this.messageBodyParamsMap = messageBodyParamsMap;
	}

	public String getVariablePattern() {
		return variablePattern;
	}

	public void setVariablePattern(String variablePattern) {
		this.variablePattern = variablePattern;
	}

	public String getMessageBodyTemplateWithAttachement() {
		return messageBodyTemplateWithAttachement;
	}

	public void setMessageBodyTemplateWithAttachement(String messageBodyTemplateWithAttachement) {
		this.messageBodyTemplateWithAttachement = messageBodyTemplateWithAttachement;
	}

	public String getMessageBodyTemplateWithOutAttachement() {
		return messageBodyTemplateWithOutAttachement;
	}

	public void setMessageBodyTemplateWithOutAttachement(String messageBodyTemplateWithOutAttachement) {
		this.messageBodyTemplateWithOutAttachement = messageBodyTemplateWithOutAttachement;
	}

	public boolean isSendWOAttachment() {
		return sendWOAttachment;
	}

	public void setSendWOAttachment(boolean sendWOAttachment) {
		this.sendWOAttachment = sendWOAttachment;
	}
	
}
