package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;
import org.springframework.util.Assert;

public class VoteMessageAdapter implements MessageAdapter {
	
	private final static String MESSAGE = "尊敬的客户，你的投票已成功，谢谢!";
	
	private final static String PROD_ID = "123000000000000007887";
	
	public final static Integer SAN = 106594508;

	@Override
	public SendingMessage convertMessage(ReceivedMessage message) {
		Assert.notNull(message, "Received Message is null!");
		String address = message.getSenderAddress();
		String senderName = message.getSan();
		String linkId = message.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
