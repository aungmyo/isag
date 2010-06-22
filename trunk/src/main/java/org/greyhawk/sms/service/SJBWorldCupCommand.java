package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public class SJBWorldCupCommand implements WorldCupCommand {
	
	private final String MESSAGE = "欢迎参与世界杯有奖竞猜,发SD到106594508冠军球队竞猜,发SP到106594508最佳球员竞猜";
	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		String address = receivedMessage.getSenderAddress();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
