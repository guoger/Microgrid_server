package com.mg.services;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		sb.append("<h1>Nodes</h1>");
		sb.append("<table border=\"1\"><tr>");
		sb.append("<th>Last update</th>" + "<th>IP</th>" + "<th>Serial</th>" + "<th>outputVoltage (V)</th>"
				+ "<th>outputCurrent (mA)</th>" + "<th>outputPower (W)</th>" + "<th>inputVoltage(V)</th>"
				+ "<th>rinputCurrent(mA)</th>" + "<th>inputPower (W)</th>" + "<th>requestedVoltage (V)</th>"
				+ "<th>requestedCurrent (mA)</th>" + "<th>requestedPower (W)</th>");
		sb.append("</tr>");

		List<MgNode> list = MgNodesDao.getNodesList();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		for (MgNode node : list) {
			sb.append("<tr>");
			sb.append("<td>").append(format.format(new Date(node.getLastUpdated()))).append("</td>");
			sb.append("<td>").append(node.getIpAddress()).append("</td>");
			sb.append("<td>").append(node.getSerialNumber()).append("</td>");
			sb.append("<td>").append(node.getVoltageOut()).append("</td>");
			sb.append("<td>").append(node.getCurrentOut()).append("</td>");
			sb.append("<td>").append(node.getOutputPower()).append("</td>");
			sb.append("<td>").append(node.getVoltageIn()).append("</td>");
			sb.append("<td>").append(node.getCurrentIn()).append("</td>");
			sb.append("<td>").append(node.getInputPower()).append("</td>");
			sb.append("<td>").append(node.getVoltageRequested()).append("</td>");
			sb.append("<td>").append(node.getCurrentRequested()).append("</td>");
			sb.append("<td>").append(node.getRequestedPower()).append("</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");

		sb.append("<h1>Power</h1><ul>");
		sb.append("<li>Max requested:").append(calculatePowerMaxRequested() + " W").append("</li>");
		sb.append("<li>Currently using:").append(calculatePowerCurrentlyUsing() + " W").append("</li>");
		sb.append("<li>Currently producing:").append(calculatePowerAvailableTotal() + " W").append("</li>");

		return sb.toString();
	}

	// TODO: move this to DAO class
	/**
	 * Calculate power requested by the nodes
	 * 
	 * @return
	 */
	private float calculatePowerMaxRequested() {
		float power = 0;
		List<MgNode> list = MgNodesDao.getNodesList();
		for (MgNode node : list) {
			power += (float) (node.getCurrentRequested() * node.getVoltageRequested()) / 1000.0f;
		}
		return power;
	}

	private float calculatePowerCurrentlyUsing() {
		float power = 0;
		List<MgNode> list = MgNodesDao.getNodesList();
		for (MgNode node : list) {
			power += (node.getCurrentOut() * node.getVoltageOut()) / 1000.0f;
		}
		return power;
	}

	private float calculatePowerAvailableTotal() {
		float power = 0;
		List<MgNode> list = MgNodesDao.getNodesList();
		for (MgNode node : list) {
			power += (node.getCurrentIn() * node.getVoltageIn()) / 1000.0f;
		}
		return power;
	}
}
