package org.greyhawk.sms.dao;

import org.greyhawk.sms.utils.TMSpringContextTests;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ReceivedMessageDaoTest extends TMSpringContextTests{
	
	@Autowired
	private ReceivedMessageDao receivedMessageDao;
	
	@Test
	public void test_save_message(){
		ReceivedMessage message = new ReceivedMessage("510**", "106**", "test", "tel:13882263026", "tel:13882263026");
		receivedMessageDao.saveReceivdMessage(message);
		Assert.assertNotNull(message.getId());
	}

}
