package com.mg.entities;

public class ResponseAuthorize {
	
	/**
	 * Possible result value, should be sent in lower case
	 * 
	 * @author saulius
	 *
	 */
	public enum Result {OK, FORBIDDEN};
	
	/**
	 * Result value, see {@link ResponseAuthorize.Result}
	 */
	private String mResult;
	
	/**
	 * Default constructor
	 */
	public ResponseAuthorize() {
		
	}
	
	/**
	 * Constructor taking Result as an argument for convenience
	 * @param result
	 */
	public ResponseAuthorize(Result result) {
		mResult = result.toString().toLowerCase();
	}
	
	/**
	 * Set {@link #mResult}
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		mResult = result;
	}
	
	/**
	 * Get {@link #mResult}
	 * 
	 * @return
	 */
	public String getResult() {
		return mResult;
	}
}
