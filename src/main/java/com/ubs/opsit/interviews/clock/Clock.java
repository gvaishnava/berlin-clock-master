package com.ubs.opsit.interviews.clock;

/**
 * @author Gaurav
 * Clock interface for generic Clock instance, it can be any type of clock.
 */
public interface Clock {
	
	/**
	 * @param time - input time
	 * @param timeformat - input time format
	 * @return - time 
	 */
	public String getDateTime(String time,String timeformat);

}
