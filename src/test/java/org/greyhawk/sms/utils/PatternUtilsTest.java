package org.greyhawk.sms.utils;

import org.junit.Test;

import junit.framework.Assert;

public class PatternUtilsTest {
	
	@Test
	public void test_get_number_ok(){
		String content = "xyw13882263026";
		String number = PatternUtils.getNumber(content);
		Assert.assertEquals("13882263026", number);
	}
	
	@Test
	public void test_get_number_return_null(){
		String content = "xyw";
		String number = PatternUtils.getNumber(content);
		Assert.assertNull(number);
	}

}
