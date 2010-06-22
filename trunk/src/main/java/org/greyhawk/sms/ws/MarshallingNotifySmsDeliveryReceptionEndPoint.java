package org.greyhawk.sms.ws;

import org.greyhawk.sms.schema.NotifySmsDeliveryReceipt;
import org.greyhawk.sms.schema.NotifySmsDeliveryReceiptResponse;
import org.greyhawk.sms.schema.ObjectFactory;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

public class MarshallingNotifySmsDeliveryReceptionEndPoint extends AbstractMarshallingPayloadEndpoint{
	
	public MarshallingNotifySmsDeliveryReceptionEndPoint(Marshaller marshaller) {
		super(marshaller);
	}
	
	@Override
	protected Object invokeInternal(Object requestObject) throws Exception {
		NotifySmsDeliveryReceipt deliveryReceipt = (NotifySmsDeliveryReceipt)requestObject;
		System.out.println("correlator:"+deliveryReceipt.getCorrelator()
				+" address:"+deliveryReceipt.getDeliveryStatus().getAddress()
				+" status:"+deliveryReceipt.getDeliveryStatus().getDeliveryStatus());
		NotifySmsDeliveryReceiptResponse response = new ObjectFactory().createNotifySmsDeliveryReceiptResponse();
		return response;
	}

}
