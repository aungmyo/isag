package org.greyhawk.sms.ws;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

public class NotifySmsReceptionEndPoint extends AbstractJDomPayloadEndpoint {
	
	public NotifySmsReceptionEndPoint() throws JDOMException {
		
	}

	@Override
	protected Element invokeInternal(Element requestElement) throws Exception {
		Namespace namespace = Namespace.getNamespace("http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local");
		Element messageElement = requestElement.getChild("message", namespace);
		String message = messageElement.getChildText("message", namespace);
		String address = messageElement.getChildText("senderAddress",namespace);
		String number = messageElement.getChildText("smsServiceActivationNumber",namespace);
		System.out.println("message:"+message+" address:"+address+" number:"+number);
		return null;
	}

}
