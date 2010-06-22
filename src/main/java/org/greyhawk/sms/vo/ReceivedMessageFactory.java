package org.greyhawk.sms.vo;

import org.jdom.Element;
import org.jdom.Namespace;

public class ReceivedMessageFactory {
	
	public static ReceivedMessage createMessage(Element headerElement,Element bodyElement){
		Namespace headerNamespace = Namespace.getNamespace("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1");
		Element element = headerElement.getChild("NotifySOAPHeader",headerNamespace);
		String linkId = element.getChildText("linkId",headerNamespace);
		String san = element.getChildText("SAN",headerNamespace);
		Namespace bodyNamespace = Namespace.getNamespace("http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local");
		Element messageElement = bodyElement.getChild("message", bodyNamespace);
		String message = messageElement.getChildText("message", bodyNamespace);
		String senderAddress = messageElement.getChildText("senderAddress",bodyNamespace);
		String smsServiceActivationNumber = messageElement.getChildText("smsServiceActivationNumber",bodyNamespace);
		return new ReceivedMessage(linkId, san, message, senderAddress, smsServiceActivationNumber);
	}

}
