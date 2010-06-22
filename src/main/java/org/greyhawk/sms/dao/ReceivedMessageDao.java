package org.greyhawk.sms.dao;

import org.greyhawk.sms.utils.BaseDaoSupport;
import org.greyhawk.sms.vo.ReceivedMessage;
import org.springframework.stereotype.Repository;

@Repository
public class ReceivedMessageDao extends BaseDaoSupport{
	
	public void saveReceivdMessage(ReceivedMessage message){
		this.getSqlMapClientTemplate().insert("ReceivedMessage.saveReceivedMessage", message);
	}
}
