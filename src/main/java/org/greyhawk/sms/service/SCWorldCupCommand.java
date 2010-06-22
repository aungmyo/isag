package org.greyhawk.sms.service;

import java.util.Date;

import org.greyhawk.sms.dao.SchedulesDao;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.Schedules;
import org.greyhawk.sms.vo.SendingMessage;

public class SCWorldCupCommand implements WorldCupCommand {
	
	private SchedulesDao schedulesDao;
	
	public SCWorldCupCommand(SchedulesDao schedulesDao){
		this.schedulesDao = schedulesDao;
	}
	

	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		Schedules schedules = schedulesDao.findSchedultsByPlayTime(new Date());
		String address = receivedMessage.getSenderAddress();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		String message = "";
		if(schedules != null)
			message = schedules.toString();
		else
			message = "尊敬的客户，今天没有世界杯相关赛程，谢谢你的参与!";
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName, message);
		return sendingMessage;
	}

}
