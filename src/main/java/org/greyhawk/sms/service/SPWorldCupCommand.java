package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public class SPWorldCupCommand implements WorldCupCommand {
	
	private final String MESSAGE = "请编辑可能获得最佳球员的编号到106594508;P1梅西P2小小罗P3卡卡P4哈维P5罗本P6鲁尼P7其他";

	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		String address = receivedMessage.getSenderAddress();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
