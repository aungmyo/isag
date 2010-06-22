package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public interface MessageAdapter {
	
	public final static int COLLECTION_SAN = 106594506;
	
	public final static int STATIS_SAN = 106594507;
	
	public final static int VOTE_SAN = 106594508;
	
	SendingMessage convertMessage(ReceivedMessage message);

}
