package org.greyhawk.sms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {
	
	private final static String PATTERN_NUMBER = "[\\d]+";
	
	public static String getNumber(String content){
		Pattern pattern = Pattern.compile(PATTERN_NUMBER);
		Matcher matcher = pattern.matcher(content);
		if(matcher.find()){
			String number = matcher.group(0);
			return number;
		}
		return null;
	}

}
