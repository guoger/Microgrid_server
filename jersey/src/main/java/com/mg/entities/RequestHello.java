package com.mg.entities;

/**
 * Entity for request Hello
 * 
 * @author Saulius Alisauskas 2012-10-05 Initial version
 * @author Saulius Alisauskas 2012-12-08 Remove parameter "ip", add javadocs
 * 
 */
public class RequestHello {

	private String mIp;

	/**
	 * Node serial number (should be unique)
	 */
	private String mSernum;

	/**
	 * Voltage feeding into the grid
	 */
	private int mVoltageIn;

	/**
	 * Current feeding into the grid
	 */
	private int mCurrentIn;

	/**
	 * Voltage that node is currently using (output voltage), in Volts
	 */
	private int mVoltageOut;

	/**
	 * Current that is currently being drawn from the node (output), in mA
	 */
	private int mCurrentOut;

	public RequestHello() {

	}

	public int getCurrentIn() {
		return mCurrentIn;
	}

	public int getCurrentOut() {
		return mCurrentOut;
	}

	public String getIp() {
		return mIp;
	}

	/**
	 * Get {@link #mSernum}
	 * 
	 * @return
	 */
	public String getSernum() {
		return mSernum;
	}

	public int getVoltageIn() {
		return mVoltageIn;
	}

	public int getVoltageOut() {
		return mVoltageOut;
	}

	public void setCurrentIn(int currentIn) {
		this.mCurrentIn = currentIn;
	}

	public void setCurrentOut(int currentUsing) {
		this.mCurrentOut = currentUsing;
	}

	public void setIp(String ip) {
		this.mIp = ip;
	}

	/**
	 * Set {@link #mSernum}
	 * 
	 * @param sernum
	 */
	public void setSernum(String sernum) {
		this.mSernum = sernum;
	}

	public void setVoltageIn(int voltageIn) {
		this.mVoltageIn = voltageIn;
	}

	public void setVoltageOut(int voltageUsing) {
		this.mVoltageOut = voltageUsing;
	}

	@Override
	public String toString() {
		return "HelloRequest [sernum=" + mSernum + "]";
	}
}
