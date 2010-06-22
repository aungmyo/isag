package org.greyhawk.sms.vo;

import java.util.Date;

public class ReceivedMessage {
	
	private Long id;
	
	private String linkId;
	
	private String san;
	
	private String message;
	
	private String senderAddress;
	
	private String smsServiceActivationNumber;
	
	private Date receivedTime;
	
	
	public ReceivedMessage(String linkId,String san,String message,String senderAddress,String smsServiceActivationNumber) {
		this.linkId = linkId;
		this.san = san;
		this.message = message;
		this.senderAddress = senderAddress;
		this.smsServiceActivationNumber = smsServiceActivationNumber;
		receivedTime = new Date();
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getSan() {
		return san;
	}

	public void setSan(String san) {
		this.san = san;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSmsServiceActivationNumber() {
		return smsServiceActivationNumber;
	}

	public void setSmsServiceActivationNumber(String smsServiceActivationNumber) {
		this.smsServiceActivationNumber = smsServiceActivationNumber;
	}
	
	
	
	public Date getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("linkId:");
		buffer.append(this.getLinkId());
		buffer.append(" san:");
		buffer.append(this.getSan());
		buffer.append(" message:");
		buffer.append(this.getMessage());
		buffer.append(" senderAddress:");
		buffer.append(this.getSenderAddress());
		buffer.append(" smsServiceActivationNumber:");
		buffer.append(this.getSmsServiceActivationNumber());
		return super.toString();
	}

}
