package org.greyhawk.sms.ws;

import org.jdom.Element;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

public class NotifySmsDeliveryReceiptEndPoint extends
		AbstractJDomPayloadEndpoint {

	@Override
	protected Element invokeInternal(Element requestElement) throws Exception {
		logger.info(requestElement);
		return null;
	}

}
