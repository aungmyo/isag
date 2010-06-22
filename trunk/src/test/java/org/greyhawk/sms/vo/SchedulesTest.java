package org.greyhawk.sms.vo;

import org.junit.Test;

public class SchedulesTest {
	
	@Test
	public void test_schedules_to_string(){
		Schedules schedules = new Schedules();
		schedules.setHostTeam("南非");
		schedules.setVisitingTeam("墨西哥");
		System.out.println(schedules.toString());
	}

}
