package org.greyhawk.sms.service;

import org.greyhawk.sms.dao.PrizePoolDao;
import org.greyhawk.sms.utils.PatternUtils;
import org.greyhawk.sms.vo.PrizePool;
import org.greyhawk.sms.vo.PrizePoolParameter;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.greyhawk.sms.vo.SendingMessage;

public class ZJWorldCupCommand implements WorldCupCommand {
	
	private final String MESSAGE = "对不起,您没能中奖. 欢迎你编辑短信SJB到106594508继续参与本活动,也许幸运的就是您.";
	
	private PrizePoolDao prizePoolDao;
	
	
	public ZJWorldCupCommand(PrizePoolDao prizePoolDao){
		this.prizePoolDao = prizePoolDao;
	}

	@Override
	public SendingMessage execute(ReceivedMessage receivedMessage) {
		String message = "";
		String address = receivedMessage.getSenderAddress();
		String accNum = PatternUtils.getNumber(address);
		PrizePoolParameter parameter = new PrizePoolParameter(accNum);
		PrizePool prizePool = prizePoolDao.queryIsDraw(parameter);
		if(prizePool == null)
			message = MESSAGE;
		else
			message = prizePool.getPrizeMessage();
		String senderName = receivedMessage.getSan();
		String linkId = receivedMessage.getLinkId();
		SendingMessage sendingMessage = new SendingMessage(PROD_ID,linkId, address, senderName,message);
		return sendingMessage;
	}

}
