package org.greyhawk.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.greyhawk.sms.dao.PrizePoolDao;
import org.greyhawk.sms.dao.SchedulesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorldCupCommandFactory {
	
	private final String SJB = "SJB";
	
	private final String SC = "SC";
	
	private final String SD = "SD";
	
	private final String SP = "SP";
	
	private final String JP = "JP";
	
	private final String ZJ = "ZJ";
	
	private List<String> result = new ArrayList<String>();
	
	@Autowired
	private SchedulesDao schedulesDao;
	
	@Autowired
	private PrizePoolDao prizePoolDao;

	
	
	public WorldCupCommandFactory() {
		result.add("A");
		result.add("B");
		result.add("C");
		result.add("Q1");
		result.add("Q2");
		result.add("Q3");
		result.add("Q4");
		result.add("Q5");
		result.add("Q6");
		result.add("Q7");
		result.add("Q8");
		result.add("P1");
		result.add("P2");
		result.add("P3");
		result.add("P4");
		result.add("P5");
		result.add("P6");
		result.add("P7");
		
	}
	
	
	
	public WorldCupCommand createCommand(String action){
		if(action.equalsIgnoreCase(SJB)){
			return new SJBWorldCupCommand();
		}
		if(action.equalsIgnoreCase(SC)){
			return new SCWorldCupCommand(schedulesDao);
		}
		if(action.equalsIgnoreCase(SD)){
			return new SDWorldCupCommand();
		}
		if(action.equalsIgnoreCase(JP)){
			return new JPWorldCupCommand();
		}
		if(action.equalsIgnoreCase(SP)){
			return new SPWorldCupCommand();
		}
		if(action.equalsIgnoreCase(ZJ)){
			return new ZJWorldCupCommand(prizePoolDao);
		}
			
		if(result.contains(action.toUpperCase())){
			return new ResultWorldCupCommand();
		}
		return new ErrorWorldCupCommand();
	}

}
