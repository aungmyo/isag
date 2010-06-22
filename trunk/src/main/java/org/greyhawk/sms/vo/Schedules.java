package org.greyhawk.sms.vo;

import java.util.Date;

public class Schedules {
	
	private Long id;
	
	private String hostTeam;
	
	private String visitingTeam;
	
	private Date playTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostTeam() {
		return hostTeam;
	}

	public void setHostTeam(String hostTeam) {
		this.hostTeam = hostTeam;
	}

	public String getVisitingTeam() {
		return visitingTeam;
	}

	public void setVisitingTeam(String visitingTeam) {
		this.visitingTeam = visitingTeam;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("今日竞猜题目是：");
		buffer.append(getHostTeam());
		buffer.append("VS");
		buffer.append(getVisitingTeam());
		buffer.append(";");
		buffer.append("A:");
		buffer.append(getHostTeam());
		buffer.append("赢；");
		buffer.append("B:");
		buffer.append(getVisitingTeam());
		buffer.append("赢；");
		buffer.append("C:平.请编辑短信A或B或C到106594508");
		return buffer.toString();
	}
	
	
	
	
}