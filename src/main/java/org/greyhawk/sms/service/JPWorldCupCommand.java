package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public class JPWorldCupCommand implements WorldCupCommand {
	
	private final String MESSAGE = "幸运者将有机会获得50元电话充值卡,价值500元运动大礼包,现金1000元等惊喜奖品";

	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		String address = receivedMessage.getSenderAddress();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
