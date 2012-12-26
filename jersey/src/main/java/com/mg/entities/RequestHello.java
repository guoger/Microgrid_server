package com.mg.entities;

/**
 * Entity for request Hello
 * 
 * @author Saulius Alisauskas 2012-10-05 Initial version
 * @author Saulius Alisauskas 2012-12-08 Remove parameter "ip", add javadocs
 * 
 */
public class RequestHello {

	private String ip;

	/**
	 * Node serial number (should be unique)
	 */
	private String sernum;

	/**
	 * Voltage that node is currently using (output voltage), in Volts
	 */
	private int voltageUsing;

	/**
	 * Current that is currently being drawn from the node (output), in mA
	 */
	private int currentUsing;

	public RequestHello() {

	}

	public int getCurrentUsing() {
		return currentUsing;
	}

	public String getIp() {
		return ip;
	}

	/**
	 * Get {@link #sernum}
	 * 
	 * @return
	 */
	public String getSernum() {
		return sernum;
	}

	public int getVoltageUsing() {
		return voltageUsing;
	}

	public void setCurrentUsing(int currentUsing) {
		this.currentUsing = currentUsing;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Set {@link #sernum}
	 * 
	 * @param sernum
	 */
	public void setSernum(String sernum) {
		this.sernum = sernum;
	}

	public void setVoltageUsing(int voltageUsing) {
		this.voltageUsing = voltageUsing;
	}

	@Override
	public String toString() {
		return "HelloRequest [sernum=" + sernum + "]";
	}
}
