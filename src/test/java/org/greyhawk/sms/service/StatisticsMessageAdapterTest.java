package org.greyhawk.sms.service;


import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;
import org.junit.Assert;
import org.junit.Test;

public class StatisticsMessageAdapterTest {
	
	@Test
	public void test_convert_message_ok(){
		ReceivedMessage message = new ReceivedMessage("10001001", "106594507", "sjb18912345678", "18912345678", "18912345678");
		MessageAdapter adapter = new StatisticsMessageAdapter();
		SendingMessage sendingMessage = adapter.convertMessage(message);
		Assert.assertEquals("已登记(18912345678),感谢你的参与!", sendingMessage.getMessage());
	}
	
	@Test
	public void test_convert_message_error_length(){
		ReceivedMessage message = new ReceivedMessage("10001001", "106594507", "sjb189123456", "1891234567", "1891234567");
		MessageAdapter adapter = new StatisticsMessageAdapter();
		SendingMessage sendingMessage = adapter.convertMessage(message);
		Assert.assertEquals("号码有误(189123456),感谢你的参与!", sendingMessage.getMessage());
	}
	
	@Test
	public void test_convert_message_error_head(){
		ReceivedMessage message = new ReceivedMessage("10001001", "106594507", "sjb13882263026", "13882263026", "13882263026");
		MessageAdapter adapter = new StatisticsMessageAdapter();
		SendingMessage sendingMessage = adapter.convertMessage(message);
		Assert.assertEquals("号段有误(13882263026),感谢你的参与!", sendingMessage.getMessage());
	}

}
