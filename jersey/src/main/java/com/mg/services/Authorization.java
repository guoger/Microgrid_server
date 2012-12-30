package com.mg.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.mg.dao.MgNodesDao;
import com.mg.entities.MgNode;
import com.mg.entities.RequestAuthorizeUsage;
import com.mg.entities.ResponseAuthorize;
import com.mg.entities.ResponseAuthorize.Result;
import com.mg.utils.Utils;

@Path("/auth")
public class Authorization {

	@Context
	HttpServletRequest request;

	Logger logger = Logger.getLogger(this.getClass());

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseAuthorize authorizePowerForNode(RequestAuthorizeUsage r) {
		boolean authorized = false;
		MgNode node = MgNodesDao.getNode(new MgNode(Utils.getOriginalAddress(request), r.getSernum()));
		if (null != node) {
			if (authorizeLoad(r.getVoltageRequested(), r.getCurrentRequested())) {				
				synchronized (node) {
					node.setCurrentRequested(r.getCurrentRequested());
					node.setVoltageRequested(r.getVoltageRequested());
				}
				authorized = true;
				logger.error("Node " + node + " authorized for voltage:" + r.getVoltageRequested() + " current:"
						+ r.getCurrentRequested());				
			} else {
				logger.info("Node with sernum:" + r.getSernum() + " was not authorized");
				// Clear requested values if those were set before
				node.setVoltageRequested(0);
				node.setCurrentRequested(0);
			}
		} else {
			logger.error("Node with sernum:" + r.getSernum() + " not found for load authorization request");
		}

		return (authorized) ? new ResponseAuthorize(Result.OK) : new ResponseAuthorize(Result.FORBIDDEN);
	}

	private boolean authorizeLoad(int voltage, int current) {
		float requestedPower = voltage * current / 1000.0f;
		float availablePower = MgNodesDao.getPowerAvailableTotal();
		float maxUsingPower = MgNodesDao.getPowerMaxRequested();
		return (maxUsingPower + requestedPower <= availablePower) ? true : false;
	}
}
