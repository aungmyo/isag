package org.greyhawk.sms.dao;

import java.util.Calendar;
import java.util.Date;

import org.greyhawk.sms.utils.TMSpringContextTests;
import org.greyhawk.sms.vo.Schedules;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SchedulesDaoTest extends TMSpringContextTests{
	
	@Autowired
	private SchedulesDao schedulesDao;
	
	
	@Test
	public void test_find_sechdules(){
		Date playTime = new Date();
		Schedules schedules =  schedulesDao.findSchedultsByPlayTime(playTime);
		Assert.assertEquals(new Long(-1), schedules.getId());
	}
	
	@Test
	public void test_find_sechdules_null(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2010, Calendar.JUNE, 28);
		Schedules schedules = schedulesDao.findSchedultsByPlayTime(calendar.getTime());
		Assert.assertNull(schedules);
	}

}
