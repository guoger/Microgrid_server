package com.mg.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.mg.dao.MgNodesDao;
import com.mg.entities.MgNode;
import com.mg.entities.RequestAuthorizeUsage;
import com.mg.utils.Utils;

@Path("/auth")
public class Authorization {

	@Context
	HttpServletRequest request;

	Logger logger = Logger.getLogger(this.getClass());

	@Path("/load")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authorizePowerForNode(RequestAuthorizeUsage r) {
		boolean authorized = false;
		if (authorizeLoad(r.getVoltageRequested(), r.getCurrentRequested())) {
			// Update node stats
			MgNode node = MgNodesDao.getNode(new MgNode(Utils.getOriginalAddress(request), r.getSernum()));
			if (null != node) {
				synchronized (node) {
					node.setCurrentRequested(r.getCurrentRequested());
					node.setVoltageRequested(r.getVoltageRequested());
				}
				authorized = true;
				logger.error("Node " + node + " authorized for voltage:" + r.getVoltageRequested() + " current:"
						+ r.getCurrentRequested());
			} else {
				logger.error("Node with sernum:" + r.getSernum() + " not found for load authorization request");
			}
		} else {
			logger.info("Node with sernum:" + r.getSernum() + " was not authorized");
		}
		return (authorized) ? Response.ok().build() : Response.status(401).build();
	}

	private boolean authorizeLoad(int voltage, int current) {
		float requestedPower = voltage * current / 1000.0f;
		float availablePower = MgNodesDao.getPowerAvailableTotal();
		float maxUsingPower = MgNodesDao.getPowerMaxRequested();
		return (maxUsingPower + requestedPower <= availablePower) ? true : false;
	}
}
