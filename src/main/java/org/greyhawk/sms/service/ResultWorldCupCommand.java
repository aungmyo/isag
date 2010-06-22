package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public class ResultWorldCupCommand implements WorldCupCommand {
	
	private final String MESSAGE = "谢谢你的参与,请您在活动结束后,编辑短信ZJ到106594508查询您是否中奖;欢迎你编辑短信SJB到106594508继续参与";

	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		String address = receivedMessage.getSenderAddress();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
