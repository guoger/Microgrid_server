package com.mg.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.mg.dao.MgNodesDao;
import com.mg.entities.MgNode;

@Path("/status")
public class Status {
	
Logger logger = Logger.getLogger(this.getClass());
	
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnStatus() {
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>Nodes</h1><ul>");
		
		List<MgNode> list = MgNodesDao.getNodesList();
		for (MgNode node : list) {
			sb.append("<li>");
			sb.append("IP:" + node.getIpAddress() + "  SERIAL:" + node.getSerialNumber() + "  VOLTAGE:" + "1" + "  CURRENT:" + "2");
			sb.append("</li>");
		}
		
		sb.append("</ul>");
		return sb.toString();
	}
}
