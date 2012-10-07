package com.mg.entities;

/**
 * Entity for request Hello
 * 
 * @author Saulius Alisauskas 2012-10-05 Initial version
 *
 */
public class RequestHello {
	private String ip;
	private String sernum;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSernum() {
		return sernum;
	}
	public void setSernum(String sernum) {
		this.sernum = sernum;
	}
	
	@Override
	public String toString() {
		return "HelloRequest [ip=" + ip + ", sernum=" + sernum + "]";
	}
}
