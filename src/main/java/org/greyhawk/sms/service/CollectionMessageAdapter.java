package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;
import org.springframework.util.Assert;

public class CollectionMessageAdapter implements MessageAdapter {
	
	private final static String MESSAGE = "谢谢你的参与!";
	
	private final static String PROD_ID = "123000000000000007930";
	

	@Override
	public SendingMessage convertMessage(ReceivedMessage message) {
		Assert.notNull(message, "Received Message is null");
		String address = message.getSenderAddress();
		String senderName = message.getSan();
		String linkId = message.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
