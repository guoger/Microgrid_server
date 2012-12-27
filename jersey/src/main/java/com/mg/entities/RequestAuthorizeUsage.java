package com.mg.entities;

/**
 * REST request for power usage authorization
 * 
 * @author Saulius Alisauskas 2012-12-27 Initial version
 * 
 */
public class RequestAuthorizeUsage {

	private String mSernum;
	private int mVoltageRequested;
	private int mCurrentRequested;

	public RequestAuthorizeUsage() {

	}

	public int getCurrentRequested() {
		return mCurrentRequested;
	}

	public String getSernum() {
		return mSernum;
	}

	public int getVoltageRequested() {
		return mVoltageRequested;
	}

	public void setCurrentRequested(int currentRequested) {
		this.mCurrentRequested = currentRequested;
	}

	public void setSernum(String sernum) {
		this.mSernum = sernum;
	}

	public void setVoltageRequested(int voltageRequested) {
		this.mVoltageRequested = voltageRequested;
	}
}
