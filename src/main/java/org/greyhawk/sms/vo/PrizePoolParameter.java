package org.greyhawk.sms.vo;


public class PrizePoolParameter {
	
	private String accNum;
	
	private boolean isDraw;
	

	public String getAccNum() {
		return accNum;
	}




	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}




	public boolean isDraw() {
		return isDraw;
	}




	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}




	public PrizePoolParameter(String accNum) {
		this.accNum = accNum;
		this.isDraw = false;
	}
	

}
