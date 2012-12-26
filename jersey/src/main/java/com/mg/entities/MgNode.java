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
	private String ipAddress;

	/**
	 * Voltage requested by node (type load) to be converted for user, in Volts
	 */
	private int voltageRequested;

	/**
	 * Current requested by node (type load), in relation to {@link #voltageRequested}, in mA
	 */
	private int currentRequested;

	/**
	 * Voltage that node is currently using (output voltage), in Volts
	 */
	private int voltageUsing;

	/**
	 * Current that is currently being drawn from the node (output), in mA
	 */
	private int currentUsing;

	/**
	 * Nodes serial number
	 */
	private String serialNumber;

	/**
	 * Timestamp when statistics were last updated
	 */
	private long lastUpdated;

	/**
	 * Custom constructor
	 * 
	 * @param ipAddress
	 */
	public MgNode(String ipAddress, String serialNumber) {
		this.ipAddress = ipAddress;
		this.serialNumber = serialNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MgNode) {
			if (((MgNode) obj).getSerialNumber().equals(serialNumber)) {
				return true;
			}
		}
		return false;
	}

	public int getCurrentRequested() {
		return currentRequested;
	}

	public int getCurrentUsing() {
		return currentUsing;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public float getOutputPower() {
		return (voltageUsing * currentUsing) / 1000.0f;
	}

	public float getRequestedPower() {
		return (voltageRequested * currentRequested) / 1000.0f;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public int getVoltageRequested() {
		return voltageRequested;
	}

	public int getVoltageUsing() {
		updateTimestamp();
		return voltageUsing;
	}

	public void setCurrentRequested(int currentRequested) {
		this.currentRequested = currentRequested;
	}

	/**
	 * Set {@link #currentUsing}
	 * 
	 * @param currentUsing
	 */
	public void setCurrentUsing(int currentUsing) {
		updateTimestamp();
		this.currentUsing = currentUsing;
	}

	/**
	 * Set {@link #voltageRequested}
	 * 
	 * @param voltageRequested
	 */
	public void setVoltageRequested(int voltageRequested) {
		this.voltageRequested = voltageRequested;
	}

	/**
	 * Set {@link #voltageUsing}
	 * 
	 * @param voltageUsing
	 */
	public void setVoltageUsing(int voltageUsing) {
		this.voltageUsing = voltageUsing;
	}

	public void updateState(MgNode node) {
		currentUsing = node.getCurrentUsing();
		voltageUsing = node.getVoltageUsing();
	}

	private void updateTimestamp() {
		lastUpdated = Calendar.getInstance().getTimeInMillis();
	}
}
