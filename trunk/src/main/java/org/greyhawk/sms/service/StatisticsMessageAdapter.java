package org.greyhawk.sms.service;

import org.greyhawk.sms.utils.PatternUtils;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class StatisticsMessageAdapter implements MessageAdapter {
	
	private final static String PROD_ID = "123000000000000007931";
		
	private final static String PREFIX_MESSAGE_OK = "已登记";
	
	private final static String PREFIX_MESSAGE_ERROR_LENGTH = "号码有误";
	
	private final static String PREFIX_MESSAGE_ERROR_HEADER = "号段有误";
	
	private final static String SUFFIX_MESSAGE = "感谢你的参与!";
	

	@Override
	public SendingMessage convertMessage(ReceivedMessage message) {
		Assert.notNull(message, "Received Message is null");
		String address = message.getSenderAddress();
		String senderName = message.getSan();
		String linkId = message.getLinkId();
		String content = this.createContent(message.getMessage());
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, content);
		return sendingMessage;
	}
	
	String createContent(String message){
		String number = PatternUtils.getNumber(message);
		if(!this.isValidLength(number,7) && !this.isValidLength(number, 11)){
			return this.composition(PREFIX_MESSAGE_ERROR_LENGTH, number);
		}
		if(this.isValidLength(number, 11)){
			if(!isValidNumberHead(number))
				return this.composition(PREFIX_MESSAGE_ERROR_HEADER, number);
		}
		return this.composition(PREFIX_MESSAGE_OK, number);
	}
	
	boolean isValidLength(String number,int length){
		if(number.trim().length() == length)
			return true;
		return false;
	}
	
	boolean isValidNumberHead(String number){
		if(StringUtils.substringMatch(number, 0, "133")||StringUtils.substringMatch(number, 0, "153")||StringUtils.substringMatch(number, 0, "189"))
			return true;
		return false;
	}
	
	
	String composition(String prefix,String number){
		StringBuffer buffer = new StringBuffer();
		buffer.append(prefix);
		buffer.append("(");
		buffer.append(number);
		buffer.append("),");
		buffer.append(SUFFIX_MESSAGE);
		return buffer.toString();
	}

}
