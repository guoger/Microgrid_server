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
			logger.warn("Node " + node + " was already in the list");
		}
	}
	
	/**
	 * Get all node objects
	 * 
	 * @return
	 */
	public static List<MgNode> getNodesList() {
		return nodeList;
	}
	
}
