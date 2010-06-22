package org.greyhawk.sms.ws.client;

import org.greyhawk.sms.utils.TMSpringContextTests;
import org.greyhawk.sms.vo.SendingMessage;
import org.junit.Test;

public class SmsSendTemplateTest extends TMSpringContextTests{
	
	@Test
	public void test_send_sms(){
		SmsSendTemplate sendTemplate = (SmsSendTemplate)this.getApplicationContext().getBean("smsSendTemplate");
		SendingMessage sendingMessage = new SendingMessage("106***", "102010****", "tel:02888859416", "106***", "test");
		sendTemplate.SendSms(sendingMessage);
	}

}
