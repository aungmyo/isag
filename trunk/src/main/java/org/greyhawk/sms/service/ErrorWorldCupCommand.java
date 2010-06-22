package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public class ErrorWorldCupCommand implements WorldCupCommand {
	
	private final String MESSAGE = "请编辑短信SJB到106594508,参与2010南非世界杯有奖竞猜,你将有机会获得惊喜大奖";

	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		String address = receivedMessage.getSenderAddress();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
