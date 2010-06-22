package org.greyhawk.sms.dao;

import java.util.Date;
import java.util.List;

import org.greyhawk.sms.utils.BaseDaoSupport;
import org.greyhawk.sms.vo.Schedules;
import org.springframework.stereotype.Repository;


@Repository
public class SchedulesDao extends BaseDaoSupport{
	
	@SuppressWarnings("unchecked")
	public Schedules findSchedultsByPlayTime(Date playTime){
		List<Schedules> list =this.getSqlMapClientTemplate().queryForList("Schedules.selectSchedulesByPlayTime", playTime);
		if(list.size()!=0)
			return list.get(0);
		return null;
	}

}
