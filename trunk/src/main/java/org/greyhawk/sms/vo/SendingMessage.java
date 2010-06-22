package org.greyhawk.sms.vo;

public class SendingMessage {
	
	private String productId;
	
	private String linkId;
	
	private String address;
	
	private String senderName;
	
	private String message;
	
	
	public SendingMessage(String productId,String linkId,String address,String senderName,String message) {
		this.productId = productId;
		this.linkId = linkId;
		this.address = address;
		this.senderName = senderName;
		this.message = message;
	}
	
	

	public String getLinkId() {
		return linkId;
	}



	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
