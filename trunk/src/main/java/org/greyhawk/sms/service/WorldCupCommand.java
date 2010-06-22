package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public interface WorldCupCommand {
	
	String PROD_ID = "123000000000000007887";
	
	SendingMessage execute(ReceivedMessage receivedMessage);

}
