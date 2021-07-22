package com.ubs.opsit.interviews.clock.util;


/**
 * @author Gaurav
 * Generic Time Validator for clock input time.
 */
public interface TimeValidator {

	
	/**
	 * Generic Time Validation method
	 * @param time - input time
	 * @param timeformat - inupt time format
	 * @return validation message
	 */
	public String validateTime(String time,String timeformat);
	
}
