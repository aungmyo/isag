package org.greyhawk.sms.ws;




import java.util.Iterator;


import org.greyhawk.sms.schema.NotifySOAPHeader;
import org.greyhawk.sms.schema.NotifySmsReception;
import org.greyhawk.sms.schema.NotifySmsReceptionResponse;
import org.greyhawk.sms.schema.ObjectFactory;
import org.greyhawk.sms.service.MessageAdapter;
import org.greyhawk.sms.service.MessageAdapterFactory;
import org.greyhawk.sms.utils.AbstractMarshallingPayloadEndpoint;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.ws.client.SmsSendTemplate;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;

public class MarshallingNotifySmsReceptionEndPoint extends
		AbstractMarshallingPayloadEndpoint {
	
	private SmsSendTemplate smsSendTemplate;
	
	public MarshallingNotifySmsReceptionEndPoint(Marshaller marshaller,SmsSendTemplate smsSendTemplate){
		super(marshaller);
		this.smsSendTemplate = smsSendTemplate;
	}
	

	@Override
	protected Object invokeInternal(MessageContext messageContext,Object requestObject) throws Exception {
		SoapMessage soapMessage = (SoapMessage)messageContext.getRequest();
		System.out.println("===================soapMessage==============");
		soapMessage.writeTo(System.out);
		SoapHeader header = soapMessage.getSoapHeader();
		SoapHeaderElement headerElement = null;
		for(Iterator iterator = header.examineAllHeaderElements();iterator.hasNext();){
			headerElement = (SoapHeaderElement) iterator.next();
		}
		NotifySOAPHeader notifySOAPHeader = (NotifySOAPHeader)this.getUnmarshaller().unmarshal(headerElement.getSource());
		System.out.println("spid:"+notifySOAPHeader.getSpId()+" linkId:"+notifySOAPHeader.getLinkId());
		NotifySmsReception reception = (NotifySmsReception)requestObject;
		System.out.println("================notify sms reception(message:"+reception.getMessage().getMessage()
				+" senderAddress:"+reception.getMessage().getSenderAddress()+" activationNumber:"+reception.getMessage().getSmsServiceActivationNumber());
		ReceivedMessage receivedMessage = new ReceivedMessage(notifySOAPHeader.getLinkId(), notifySOAPHeader.getSAN()
																, reception.getMessage().getMessage(), reception.getMessage().getSenderAddress()
																, reception.getMessage().getSmsServiceActivationNumber());
		MessageAdapter adapter = new MessageAdapterFactory().createMessageAdapter(receivedMessage.getSan());
		smsSendTemplate.SendSms(adapter.convertMessage(receivedMessage));
		NotifySmsReceptionResponse response = new ObjectFactory().createNotifySmsReceptionResponse();
		return response;
	}

}
