package org.greyhawk.sms.ws;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

public class SendSmsEndPoint extends AbstractJDomPayloadEndpoint{
	
	
	public SendSmsEndPoint() throws JDOMException{
	}
	
	@Override
	protected Element invokeInternal(Element requestElement) throws Exception {
		logger.info(requestElement.toString());
		return null;
	}

}
