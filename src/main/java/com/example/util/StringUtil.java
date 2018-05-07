package com.example.util;

public class StringUtil {
	/**
	 * 判断是否为空串
	 * 
	 * @param str
	 *            判断的字符串
	 * @return 判断是否空串
	 */
	public static boolean isBlankStr(String str) {
		if ((str == null) || (str.trim().length() == 0)) {
			return true;
		}
		return false;
	}
	
	public static final boolean isEmpty(String str) {
		return null == str || str.isEmpty();
	}
}
