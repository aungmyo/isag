package org.greyhawk.sms.service;

import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorldCupMessageAdapter implements MessageAdapter {
	
	@Autowired
	private WorldCupCommandFactory worldCupCommandFactory;

	@Override
	public SendingMessage convertMessage(ReceivedMessage message) {
		WorldCupCommand command = worldCupCommandFactory.createCommand(message.getMessage());
		return command.execute(message);
	}

}
