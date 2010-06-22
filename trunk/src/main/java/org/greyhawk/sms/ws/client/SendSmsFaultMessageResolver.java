package org.greyhawk.sms.ws.client;

import java.io.IOException;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.FaultMessageResolver;

public class SendSmsFaultMessageResolver implements FaultMessageResolver {

	@Override
	public void resolveFault(WebServiceMessage message) throws IOException {
		System.out.println("Send SMS has error:");
		message.writeTo(System.out);
	}

}
