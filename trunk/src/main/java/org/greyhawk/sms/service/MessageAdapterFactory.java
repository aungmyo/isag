package org.greyhawk.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessageAdapterFactory {
	
	@Autowired
	private MessageAdapter worldCupMessageAdapter;
	
	
	
	public MessageAdapter createMessageAdapter(String san){
		switch (new Integer(san)) {
		case MessageAdapter.COLLECTION_SAN:
			return new CollectionMessageAdapter();
		case MessageAdapter.STATIS_SAN:
			return new StatisticsMessageAdapter();
		case MessageAdapter.VOTE_SAN:
			return worldCupMessageAdapter;
		default:
			return null;
		}
	}

}
