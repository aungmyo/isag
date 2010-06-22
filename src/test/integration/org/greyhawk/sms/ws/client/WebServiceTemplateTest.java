package org.greyhawk.sms.ws.client;


import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.greyhawk.sms.schema.ObjectFactory;
import org.greyhawk.sms.schema.RequestSOAPHeader;
import org.greyhawk.sms.schema.SendSms;
import org.greyhawk.sms.utils.TMSpringContextTests;
import org.junit.Test;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;


public class WebServiceTemplateTest extends TMSpringContextTests{
	
	
	@Test
	public void test_send_message_can_access(){
		WebServiceTemplate webServiceTemplate = (WebServiceTemplate)this.getApplicationContext().getBean("webServiceTemplate");
		SendSms sendSms = new ObjectFactory().createSendSms();
		sendSms.getAddresses().add("8602888859416");
		sendSms.setMessage("test");
		webServiceTemplate.marshalSendAndReceive(sendSms);
	}
	
	@Test
	public void test_marshal_message(){
		Jaxb2Marshaller marshaller = (Jaxb2Marshaller)this.getApplicationContext().getBean("jaxb2Marshaller");
		SendSms sendSms = new ObjectFactory().createSendSms();
		sendSms.getAddresses().add("8602888859416");
		sendSms.setMessage("test");
		StreamResult result = new StreamResult(System.out);
		marshaller.marshal(sendSms, result);
	}
	
	@Test
	public void test_send_message_by_soap_head(){
		WebServiceTemplate webServiceTemplate = (WebServiceTemplate)this.getApplicationContext().getBean("webServiceTemplate");
		SendSms sendSms = new ObjectFactory().createSendSms();
		sendSms.getAddresses().add("8602888859416");
		sendSms.setMessage("test");
		webServiceTemplate.marshalSendAndReceive(sendSms, new WebServiceMessageCallback() {
			@Override
			public void doWithMessage(WebServiceMessage message) throws IOException,
					TransformerException {
				try {
					RequestSOAPHeader requestSOAPHeader = new ObjectFactory().createRequestSOAPHeader();
					requestSOAPHeader.setSpId("23126222");
					requestSOAPHeader.setSpPassword("e5ca85fdc530f2f7c9796797649a6ca2");
					requestSOAPHeader.setTimeStamp("0521161212");
					requestSOAPHeader.setProductId("123000000000000006866");
					requestSOAPHeader.setOA("tel:+8602888859416");
					SoapHeader header = ((SoapMessage)message).getSoapHeader();
					JAXBSource source = new JAXBSource(JAXBContext.newInstance("org.greyhawk.sms.schema"), requestSOAPHeader);
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(source, header.getResult());
					message.writeTo(System.out);
				} catch (JAXBException e) {
					e.printStackTrace(); 
				}
			}
		});
	}
	

}
