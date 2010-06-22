package org.greyhawk.sms.ws.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.greyhawk.sms.schema.ChargingInformation;
import org.greyhawk.sms.schema.ObjectFactory;
import org.greyhawk.sms.schema.RequestSOAPHeader;
import org.greyhawk.sms.schema.SendSms;
import org.greyhawk.sms.schema.SendSmsResponse;
import org.greyhawk.sms.utils.MD5Generator;
import org.greyhawk.sms.vo.SendingMessage;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

public class SmsSendTemplate {
	
	public final static String VOTE_MESSAGE ="尊敬的客户，你的投票已成功，谢谢";
	
	private WebServiceTemplate webServiceTemplate;
	
	
	public SmsSendTemplate(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}
	
	public void SendSms(SendingMessage smsMessage){
		SendSms sms = this.createSms(smsMessage);
		final RequestSOAPHeader requestSOAPHeader = this.createSOAPHeader(smsMessage);
		SendSmsResponse response = (SendSmsResponse)webServiceTemplate.marshalSendAndReceive(sms, new WebServiceMessageCallback() {			
			@Override
			public void doWithMessage(WebServiceMessage message) throws IOException,
					TransformerException {
				SoapHeader header = ((SoapMessage)message).getSoapHeader();
				JAXBSource source;
				try {
					source = new JAXBSource(JAXBContext.newInstance("org.greyhawk.sms.schema"), requestSOAPHeader);
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(source, header.getResult());
					message.writeTo(System.out);
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				
			}
		});
		if(response != null)
			System.out.println("====================send sms response:"+response.getResult());
	}
	
	public SendSms createSms(SendingMessage smsMessage){
		SendSms sms = new ObjectFactory().createSendSms();
		sms.getAddresses().add(smsMessage.getAddress());
		sms.setMessage(smsMessage.getMessage());
		sms.setSenderName(smsMessage.getSenderName());
		sms.setCharging(this.createChargingInformation(smsMessage.getAddress()));
		return sms;
	}
	
	
	public ChargingInformation createChargingInformation(String address){
		ChargingInformation information = new ObjectFactory().createChargingInformation();
		information.setDescription("Charging");
		information.setCurrency("");
		information.setAmount(new BigDecimal(0));
		information.setCode(address);
		return information;
	}
	
	public RequestSOAPHeader createSOAPHeader(SendingMessage smsMessage){
		RequestSOAPHeader requestSOAPHeader = new ObjectFactory().createRequestSOAPHeader();
		String timeStamp = this.createTimeStamp();
		String pwd = this.createPassword(timeStamp);
		requestSOAPHeader.setSpId(SpInfo.SP_ID);
		requestSOAPHeader.setSpPassword(pwd);
		requestSOAPHeader.setTimeStamp(timeStamp);
		requestSOAPHeader.setProductId(smsMessage.getProductId());
		requestSOAPHeader.setOA(smsMessage.getAddress());
		requestSOAPHeader.setLinkId(smsMessage.getLinkId());
		requestSOAPHeader.setFA(smsMessage.getAddress());
		return requestSOAPHeader;
	}
	
	public String createTimeStamp(){
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
		return format.format(new Date());
	}
	
	public String createPassword(String timeStamp){
		StringBuffer buffer = new StringBuffer();
		buffer.append(SpInfo.SP_ID);
		buffer.append(SpInfo.SP_PWD);
		buffer.append(timeStamp);
		return MD5Generator.encryptByMD5(buffer.toString());
	}

}
