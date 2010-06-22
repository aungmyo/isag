package org.greyhawk.sms.vo;

import java.util.Date;

public class PrizePool {
	
	private final String PRIZE_CARD_MESSAGE = "恭喜您,您获得了本活动提供的50元电话充值卡,活动结束后,将自动充到你的电话机上. 欢迎你继续编辑短信SJB到106594508参与本活动.";
	
	private final String PRIZE_CASH_MESSAGE = "恭喜您,您获得了本活动的幸运大奖现金500元;请你拨打电话160联系领奖事宜.";
	
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
		return null;
	}
	

}
