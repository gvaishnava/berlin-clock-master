package com.ubs.opsit.interviews.clock.util;

/**
 * @author Gaurav
 * Generic TimeConverter interface to be implemented by Specific Classes
 */
public interface TimeConverter {

    /**User can enter time in any format we need to add validation 
	 * by which we can identify input time details.
     * @param input Time 
     * @return conveted Time for type of clock.
     */
    public String convertTime(String aTime);
}
