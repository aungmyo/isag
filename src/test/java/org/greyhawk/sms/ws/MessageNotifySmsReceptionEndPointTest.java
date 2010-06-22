package org.greyhawk.sms.ws;

import java.io.IOException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.greyhawk.sms.utils.TMSpringContextTests;
import org.junit.Test;
import org.springframework.ws.WebServiceMessage;

public class MessageNotifySmsReceptionEndPointTest extends TMSpringContextTests {
	
	@Test
	public void test_create_response() throws TransformerConfigurationException, TransformerException, IOException{
		MessageNotifySmsReceptionEndPoint endPoint= (MessageNotifySmsReceptionEndPoint)this.getApplicationContext().getBean("messageNotifySmsReceptionEndPoint");
		WebServiceMessage message = endPoint.createResponse();
		message.writeTo(System.out);
	}

}
