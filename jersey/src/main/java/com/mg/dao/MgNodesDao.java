package com.mg.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mg.entities.MgNode;

//TODO: this is a temporary solutions without persistence
/**
 * Nodes data object provider.
 * 
 * @author Saulius Alisauskas 2012-10-05 Initial version
 * 
 */
public final class MgNodesDao {
	private static final List<MgNode> nodeList = new ArrayList<MgNode>();
	private static Logger logger = Logger.getLogger(MgNodesDao.class);

	/**
	 * Add node to the list
	 * 
	 * @param node
	 */
	public static void addNode(MgNode node) {
		if (!nodeList.contains(node)) {
			nodeList.add(node);
		} else {
			// Update node status variables
			nodeList.get(nodeList.indexOf(node)).updateState(node);
		}
	}
	
	public static MgNode getNode(MgNode node) {
		if (nodeList.contains(node)) {
			return nodeList.get(nodeList.indexOf(node));
		} 
		return null;
	}

	/**
	 * Get all node objects
	 * 
	 * @return
	 */
	public static List<MgNode> getNodesList() {
		return nodeList;
	}
	
	/**
	 * Returns power requested by the nodes on the grid
	 * 
	 * @return
	 */
	public static float getPowerMaxRequested() {
		float power = 0;
		List<MgNode> list = MgNodesDao.getNodesList();
		for (MgNode node : list) {
			power += (float) (node.getCurrentRequested() * node.getVoltageRequested()) / 1000.0f;
		}
		return power;
	}

	/**
	 * Return power currently being draw from the grid
	 * 
	 * @return
	 */
	public static float getPowerCurrentlyUsing() {
		float power = 0;
		List<MgNode> list = MgNodesDao.getNodesList();
		for (MgNode node : list) {
			power += (node.getCurrentOut() * node.getVoltageOut()) / 1000.0f;
		}
		return power;
	}
	
	/**
	 * Returns power currently available in the grid
	 * 
	 * @return
	 */
	public static float getPowerAvailableTotal() {
		float power = 0;
		List<MgNode> list = MgNodesDao.getNodesList();
		for (MgNode node : list) {
			power += (node.getCurrentIn() * node.getVoltageIn()) / 1000.0f;
		}
		return power;
	}

}
