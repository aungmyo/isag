package org.greyhawk.sms.utils;

import junit.framework.Assert;

import org.junit.Test;

public class MD5GeneratorTest {
	
	@Test
	public void test_md5_encrypt(){
		String sourceStr = "23126222dazhoudianxin0521173820";
		String targetStr = MD5Generator.encryptByMD5(sourceStr);
		Assert.assertEquals("e5ca85fdc530f2f7c9796797649a6ca2", targetStr);
	}

}
