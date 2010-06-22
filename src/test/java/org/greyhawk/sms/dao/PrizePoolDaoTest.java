package org.greyhawk.sms.dao;

import org.greyhawk.sms.utils.TMSpringContextTests;
import org.greyhawk.sms.vo.PrizePool;
import org.greyhawk.sms.vo.PrizePoolParameter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PrizePoolDaoTest extends TMSpringContextTests{
	
	@Autowired
	private PrizePoolDao prizePoolDao;
	
	@Test
	public void test_query_prize_pool(){
		PrizePoolParameter parameter = new PrizePoolParameter("13882263026");
		PrizePool pool = prizePoolDao.queryIsDraw(parameter);
		System.out.println(pool.getPrizeMessage());
	}

}
