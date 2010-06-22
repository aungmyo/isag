package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public class SDWorldCupCommand implements WorldCupCommand {
	
	private final String MESSAGE = "请编辑球队编号到106594508;Q1巴西Q2阿根廷Q3西班牙Q4英格兰Q5荷兰Q6德国Q7意大利Q8其他";
	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		String address = receivedMessage.getSenderAddress();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, MESSAGE);
		return sendingMessage;
	}

}
