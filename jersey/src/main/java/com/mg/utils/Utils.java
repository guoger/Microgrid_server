package com.mg.utils;
import javax.servlet.http.HttpServletRequest;


public class Utils {
	
	public static final String HEADER_ORIGINAL_ADDRESS = "X-Forwarded-For";
	public static String getOriginalAddress(HttpServletRequest request) {
		String originalIp = request.getHeader(HEADER_ORIGINAL_ADDRESS);
		if (null == originalIp) {
			originalIp = request.getRemoteAddr();
		}
		return originalIp;
	}

}
