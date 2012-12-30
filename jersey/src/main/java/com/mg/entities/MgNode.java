package com.mg.entities;

import java.util.Calendar;

/**
 * Microgrid node entity
 * 
 * @author Saulius Alisauskas
 * 
 */
public class MgNode {

	/**
	 * Nodes ip address
	 */
	private String mIpAddress;

	/**
	 * Voltage feeding into the grid
	 */
	private float mVoltageIn;

	/**
	 * Current feeding into the grid
	 */
	private float mCurrentIn;

	/**
	 * Voltage requested by node (type load) to be converted for user, in Volts
	 */
	private float mVoltageRequested;

	/**
	 * Current requested by node (type load), in relation to {@link #mVoltageRequested}, in mA
	 */
	private float mVurrentRequested;

	/**
	 * Voltage that node is currently using (output voltage), in Volts
	 */
	private float mVoltageOut;

	/**
	 * Current that is currently being drawn from the node (output), in mA
	 */
	private float mCurrentOut;

	/**
	 * Nodes serial number
	 */
	private String mSerialNumber;

	/**
	 * Timestamp when statistics were last updated
	 */
	private long mLastUpdated;

	/**
	 * Custom constructor
	 * 
	 * @param ipAddress
	 */
	public MgNode(String ipAddress, String serialNumber) {
		this.mIpAddress = ipAddress;
		this.mSerialNumber = serialNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MgNode) {
			if (((MgNode) obj).getSerialNumber().equals(mSerialNumber)) {
				return true;
			}
		}
		return false;
	}

	public float getCurrentIn() {
		return mCurrentIn;
	}

	public float getCurrentOut() {
		return mCurrentOut;
	}

	public float getCurrentRequested() {
		return mVurrentRequested;
	}

	public String getIpAddress() {
		return mIpAddress;
	}

	public long getLastUpdated() {
		return mLastUpdated;
	}

	public float getOutputPower() {
		return (mVoltageOut * mCurrentOut) / 1000.0f;
	}
	
	public float getInputPower() {
		return (mVoltageIn * mCurrentIn) / 1000.0f;
	}

	public float getRequestedPower() {
		return (mVoltageRequested * mVurrentRequested) / 1000.0f;
	}

	public String getSerialNumber() {
		return mSerialNumber;
	}

	public float getVoltageIn() {
		return mVoltageIn;
	}

	public float getVoltageOut() {		
		return mVoltageOut;
	}

	public float getVoltageRequested() {
		return mVoltageRequested;
	}

	public void setCurrentIn(float currentIn) {		
		mCurrentIn = currentIn;
	}

	/**
	 * Set {@link #mCurrentOut}
	 * 
	 * @param currentUsing
	 */
	public void setCurrentOut(float currentUsing) {		
		mCurrentOut = currentUsing;
	}

	public void setCurrentRequested(float currentRequested) {
		mVurrentRequested = currentRequested;
	}

	public void setVoltageIn(float voltageIn) {		
		mVoltageIn = voltageIn;
	}

	/**
	 * Set {@link #mVoltageOut}
	 * 
	 * @param voltageUsing
	 */
	public void setVoltageOut(float voltageUsing) {		
		mVoltageOut = voltageUsing;
	}

	/**
	 * Set {@link #mVoltageRequested}
	 * 
	 * @param voltageRequested
	 */
	public void setVoltageRequested(int voltageRequested) {
		this.mVoltageRequested = voltageRequested;
	}

	public void updateState(MgNode node) {
		synchronized (this) {
			mCurrentOut = node.getCurrentOut();
			mVoltageOut = node.getVoltageOut();
			mCurrentIn = node.getCurrentIn();
			mVoltageIn = node.getVoltageIn();
			updateTimestamp();
		}		
	}

	private void updateTimestamp() {
		mLastUpdated = Calendar.getInstance().getTimeInMillis();
	}
}
