package com.ubs.opsit.interviews.clock.factory;

import com.ubs.opsit.interviews.clock.impl.BerlinClock;
import com.ubs.opsit.interviews.clock.Clock;

/**
 * @author Gaurav
 * ClockFactory implementation. 
 */
public class ClockFactory {
	
	/**
	 * We need BerlinClock instance only so we are hiding other
	 * implementation detail and exposing getInstance method only.
	 * @return Desired clock object
	 */
	public static Clock getBerlinClock(){
		return BerlinClock.getInstance();
	}
}
