package org.greyhawk.sms.service;

import org.greyhawk.sms.utils.TMSpringContextTests;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WorldCupCommandFactoryTest extends TMSpringContextTests {
	
	@Autowired
	private WorldCupCommandFactory worldCupCommandFactory;
	
	@Test
	public void test_SJB_command(){
		ReceivedMessage receivedMessage = new ReceivedMessage("100001", "1111", "SJB", "18908201001", "10001");
		WorldCupCommand command = worldCupCommandFactory.createCommand(receivedMessage.getMessage());
		SendingMessage message = command.execute(receivedMessage);
		System.out.println(message.getMessage());
		
	}
	
	@Test
	public void test_SC_command(){
		ReceivedMessage receivedMessage = new ReceivedMessage("100001", "1111", "SC", "18908201001", "10001");
		WorldCupCommand command = worldCupCommandFactory.createCommand(receivedMessage.getMessage());
		SendingMessage message = command.execute(receivedMessage);
		System.out.println(message.getMessage());
	}
	
	@Test
	public void test_SD_command(){
		ReceivedMessage receivedMessage = new ReceivedMessage("100001", "1111", "SD", "18908201001", "10001");
		WorldCupCommand command = worldCupCommandFactory.createCommand(receivedMessage.getMessage());
		SendingMessage message = command.execute(receivedMessage);
		System.out.println(message.getMessage());
	}
	
	@Test
	public void test_JP_command(){
		ReceivedMessage receivedMessage = new ReceivedMessage("100001", "1111", "JP", "18908201001", "10001");
		WorldCupCommand command = worldCupCommandFactory.createCommand(receivedMessage.getMessage());
		SendingMessage message = command.execute(receivedMessage);
		System.out.println(message.getMessage());
	}
	
	@Test
	public void test_A_command(){
		ReceivedMessage receivedMessage = new ReceivedMessage("100001", "1111", "A", "18908201001", "10001");
		WorldCupCommand command = worldCupCommandFactory.createCommand(receivedMessage.getMessage());
		SendingMessage message = command.execute(receivedMessage);
		System.out.println(message.getMessage());
	}
	
	@Test
	public void test_error_command(){
		ReceivedMessage receivedMessage = new ReceivedMessage("100001", "1111", "error", "18908201001", "10001");
		WorldCupCommand command = worldCupCommandFactory.createCommand(receivedMessage.getMessage());
		SendingMessage message = command.execute(receivedMessage);
		System.out.println(message.getMessage());
	}

}
