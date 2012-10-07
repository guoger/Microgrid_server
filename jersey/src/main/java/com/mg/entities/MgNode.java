package com.mg.entities;

/**
 * Microgrid node entity
 * 
 * @author Saulius Alisauskas
 *
 */
public class MgNode {
	
	/**
	 * Types of nodes
	 * @author Saulius Alisauskas
	 *
	 */
	public enum NODE_TYPE {DCDC};
	
	/**
	 * Nodes ip address
	 */
	private String ipAddress;
	
	/**
	 * Nodes type
	 */
	private NODE_TYPE type;
	
	/**
	 * Nodes serial number
	 */
	private String serialNumber;
	
	/**
	 * Custom constructor
	 * 
	 * @param ipAddress
	 */
	public MgNode(String ipAddress, String serialNumber) {
		this.ipAddress = ipAddress;
		this.serialNumber = serialNumber;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MgNode) {
			if (((MgNode)obj).getSerialNumber().equals(serialNumber)) {
				return true;
			}
		}
		return false;
	}
}
