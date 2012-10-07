package com.mg.services;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.sun.jersey.api.model.AbstractResourceModelContext;
import com.sun.jersey.api.model.AbstractResourceModelListener;

@Provider
public class TestLoader implements AbstractResourceModelListener {

	@Context
	private static ServletContext context;
	private static Logger logger = Logger.getLogger(TestLoader.class);
	private static final int PAUSE = 2;
	
	@Override
	public void onLoaded(AbstractResourceModelContext modelContext) {
		System.out.println("Loaded");
		logger.info("onLoad");
	}
}
