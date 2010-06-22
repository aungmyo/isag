package org.greyhawk.sms.utils;

import org.springframework.test.AbstractTransactionalSpringContextTests;

public class TMSpringContextTests extends AbstractTransactionalSpringContextTests {

	@Override
	protected String[] getConfigLocations() {
		 return new String[]{"applicationContext.xml","applicationContext-datasource.xml","applicationContext-client.xml"};
	}

}
