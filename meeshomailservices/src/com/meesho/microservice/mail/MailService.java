package com.meesho.microservice.mail;

import java.util.HashMap;

import com.meesho.microservice.NotificationService;
import com.meesho.microservices.entities.GenericMessage;
import com.meesho.microservices.entities.GenericNotificationObject;
import com.meesho.microservices.entities.MailAttachment;

public class MailService implements NotificationService{
	
	@Override
	public void sendNotification(GenericMessage msg) {
		GenericNotificationObject mailObject = createMailObject(msg);
		String mailBody = populateMail(mailObject);
		sendMail(mailObject.getMailTo(),mailObject.getMailFrom(), mailBody ,mailObject.isSendWOAttachment());
	}
	
	private static String variableSubstitution(String template,String pattern, HashMap<String,String> variableValueMap) {
		// TODO Java Pattern Matcher will be used to populate the variables in the template
		String populatedTemplate = "";
		return populatedTemplate;
	}
	private static void sendMail(String to,String from, String body,boolean withAttachment ) {
		 //send mail using the params
	}
	private static String populateMail(GenericNotificationObject mailObject) {
		//TODO check If Attachment is present
		if(mailObject.getAttachments() == null || mailObject.getAttachments().length == 0) {
			mailObject.setSendWOAttachment(false);
			return variableSubstitution(mailObject.getMessageBodyTemplateWithOutAttachement(),mailObject.getVariablePattern(),mailObject.getMessageBodyParamsMap());
		}
		for(MailAttachment attachment : mailObject.getAttachments()) {
			 if(attachment.getAttachmentLocation() == null || attachment.getAttachmentLocation() != "") {
				 mailObject.setSendWOAttachment(false);
				 return variableSubstitution(mailObject.getMessageBodyTemplateWithOutAttachement(),mailObject.getVariablePattern(),mailObject.getMessageBodyParamsMap()); 
			 }
		}
		mailObject.setSendWOAttachment(true);
		return variableSubstitution(mailObject.getMessageBodyTemplateWithAttachement(),mailObject.getVariablePattern(),mailObject.getMessageBodyParamsMap());
	}
	private static GenericNotificationObject createMailObject(GenericMessage msg) {
		//TODO convert the generic message to Mail Object
		GenericNotificationObject mailObject = null;
		return mailObject;
	}




}
