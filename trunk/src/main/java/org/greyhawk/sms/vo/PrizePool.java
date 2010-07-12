package org.greyhawk.sms.vo;

import java.util.Date;

public class PrizePool {
	
	private final String PRIZE_CARD_MESSAGE = "恭喜你,获得本次活动提供的50元电话充值卡,将在8月初直接充到你的手机卡上";
	
	private final String PRIZE_CASH_MESSAGE = "恭喜你,获得本次活动提供的500元现金奖励";
	
	private final String PRIZE_MAX_CASH_MESSAGE = "恭喜你,获得本次活动提供的1000元现金奖励";
	
	private Long id;
	
	private String accNum;
	
	private int prizeType;
	
	private Date prizeTime;
	
	private boolean isDraw;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public int getPrizeType() {
		return prizeType;
	}

	public void setPrizeType(int prizeType) {
		this.prizeType = prizeType;
	}

	public Date getPrizeTime() {
		return prizeTime;
	}

	public void setPrizeTime(Date prizeTime) {
		this.prizeTime = prizeTime;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}
	
	public String getPrizeMessage(){
		if(getPrizeType() == 1)
			return this.PRIZE_CARD_MESSAGE;
		if(getPrizeType() == 2)
			return this.PRIZE_CASH_MESSAGE;
		if(getPrizeType() == 3)
			return this.PRIZE_MAX_CASH_MESSAGE;
		return null;
	}
	

}
