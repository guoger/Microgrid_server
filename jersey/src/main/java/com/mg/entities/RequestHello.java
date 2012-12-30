package com.mg.entities;

/**
 * Entity for request Hello
 * 
 * @author Saulius Alisauskas 2012-10-05 Initial version
 * @author Saulius Alisauskas 2012-12-08 Remove parameter "ip", add javadocs
 * 
 */
public class RequestHello {

	
	private String mBangState;
	
	private String mIp;

	/**
	 * Node serial number (should be unique)
	 */
	private String mSernum;

	/**
	 * Voltage feeding into the grid
	 */
	private float mVoltageIn;

	/**
	 * Current feeding into the grid
	 */
	private float mCurrentIn;

	/**
	 * Voltage that node is currently using (output voltage), in Volts
	 */
	private float mVoltageOut;

	/**
	 * Current that is currently being drawn from the node (output), in mA
	 */
	private float mCurrentOut;

	public RequestHello() {

	}

	public String getBangState() {
		return mBangState;
	}

	public float getCurrentIn() {
		return mCurrentIn;
	}

	public float getCurrentOut() {
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

	public float getVoltageIn() {
		return mVoltageIn;
	}

	public float getVoltageOut() {
		return mVoltageOut;
	}

	public void setBangState(String bangState) {
		this.mBangState = bangState;
	}

	public void setCurrentIn(float currentIn) {
		this.mCurrentIn = currentIn;
	}

	public void setCurrentOut(float currentUsing) {
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

	public void setVoltageIn(float voltageIn) {
		this.mVoltageIn = voltageIn;
	}

	public void setVoltageOut(float voltageUsing) {
		this.mVoltageOut = voltageUsing;
	}

	@Override
	public String toString() {
		return "HelloRequest [sernum=" + mSernum + "]";
	}
}
