package org.greyhawk.sms.ws;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;

import org.greyhawk.sms.dao.ReceivedMessageDao;
import org.greyhawk.sms.service.MessageAdapter;
import org.greyhawk.sms.service.MessageAdapterFactory;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.ReceivedMessageFactory;
import org.greyhawk.sms.ws.client.SmsSendTemplate;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.MessageEndpoint;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.xml.transform.TransformerObjectSupport;
import org.w3c.dom.Node;

public class MessageNotifySmsReceptionEndPoint extends TransformerObjectSupport implements MessageEndpoint {
	
	
	private SmsSendTemplate smsSendTemplate;
	
	private SaajSoapMessageFactory saajSoapMessageFactory;
	
	@Autowired
	private ReceivedMessageDao receivedMessageDao;
	
	@Autowired
	private MessageAdapterFactory messageAdapterFactory;
	
	public MessageNotifySmsReceptionEndPoint(SmsSendTemplate smsSendTemplate,SaajSoapMessageFactory messageFactory) {
		this.smsSendTemplate = smsSendTemplate;
		this.saajSoapMessageFactory = messageFactory;
	}

	@Override
	public void invoke(MessageContext messageContext) throws Exception {
		SoapMessage message = (SoapMessage)messageContext.getRequest();
		message.writeTo(System.out);
		Source headerSource = message.getSoapHeader().getSource();
		Source bodySource = message.getSoapBody().getPayloadSource();
		Element headerElement = this.getDocumentElement(headerSource);
		Element bodyElement = this.getDocumentElement(bodySource);
		ReceivedMessage receivedMessage = ReceivedMessageFactory.createMessage(headerElement, bodyElement);
		System.out.println("===========receive message:"+receivedMessage.toString());
		receivedMessageDao.saveReceivdMessage(receivedMessage);
		MessageAdapter adapter = messageAdapterFactory.createMessageAdapter(receivedMessage.getSan());
		smsSendTemplate.SendSms(adapter.convertMessage(receivedMessage));
		messageContext.setResponse(this.createResponse());
	}
	
	public WebServiceMessage createResponse() throws TransformerConfigurationException, TransformerException{
		WebServiceMessage message =  saajSoapMessageFactory.createWebServiceMessage();
		Result result = message.getPayloadResult();
		Element element = new Element("notifySmsReceptionResponse","http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local");
		JDOMSource source = new JDOMSource(element);
		transform(source, result);
		return message;
	}
	
	 protected Element getDocumentElement(Source source) throws TransformerException {
	        if (source == null) {
	            return null;
	        }
	        if (source instanceof DOMSource) {
	            Node node = ((DOMSource) source).getNode();
	            DOMBuilder domBuilder = new DOMBuilder();
	            if (node.getNodeType() == Node.ELEMENT_NODE) {
	                return domBuilder.build((org.w3c.dom.Element) node);
	            }
	            else if (node.getNodeType() == Node.DOCUMENT_NODE) {
	                Document document = domBuilder.build((org.w3c.dom.Document) node);
	                return document.getRootElement();
	            }
	        }
	        // we have no other option than to transform
	        JDOMResult jdomResult = new JDOMResult();
	        transform(source, jdomResult);
	        return jdomResult.getDocument().getRootElement();
	    }

}
