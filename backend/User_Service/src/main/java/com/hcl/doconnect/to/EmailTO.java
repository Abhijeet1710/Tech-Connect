package com.hcl.doconnect.to;

public class EmailTO {
	
	private String recipient;
	private String messageBody;
	private String subject;
	
	public EmailTO() {
		super();

	}

	public EmailTO(String recipient, String messageBody, String subject) {
		super();
		this.recipient = recipient;
		this.messageBody = messageBody;
		this.subject = subject;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
