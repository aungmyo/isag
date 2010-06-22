package org.greyhawk.sms.dao;

import java.util.List;

import org.greyhawk.sms.utils.BaseDaoSupport;
import org.greyhawk.sms.vo.PrizePool;
import org.greyhawk.sms.vo.PrizePoolParameter;
import org.springframework.stereotype.Repository;

@Repository
public class PrizePoolDao extends BaseDaoSupport {
	
	@SuppressWarnings("unchecked")
	public PrizePool queryIsDraw(PrizePoolParameter parameter){
		List<PrizePool> list = this.getSqlMapClientTemplate().queryForList("PrizePool.queryIsDraw", parameter);
		if(list.size()!=0)
			return list.get(0);
		return null;
	}

}
