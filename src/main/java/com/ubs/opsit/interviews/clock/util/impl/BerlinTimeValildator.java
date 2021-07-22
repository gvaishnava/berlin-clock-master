package com.ubs.opsit.interviews.clock.util.impl;

import com.ubs.opsit.interviews.clock.constants.Constants;
import com.ubs.opsit.interviews.clock.util.TimeValidator;

/**
 * @author Gaurav
 * TimeValidtor implementation for input Berlin Time Validation 
 */
public class BerlinTimeValildator implements TimeValidator {
	
	
	/**
	 * Constructor
	 */
	public BerlinTimeValildator(){
		
	}
	

	/* (non-Javadoc)
	 * validate input time and time format
	 * @see com.ubs.opsit.interviews.clock.util.TimeValidator#validateTime(java.lang.String, java.lang.String)
	 */
	@Override
	public String validateTime(String time,String timeformat){
		
		if(time.contains(":")){
			String timeArray[] = time.split(":");
			
			if(!timeformat.equals(Constants.Hours_Minutes_Seconds)){
				return "Supported format is "+Constants.Hours_Minutes_Seconds+", Please pick System Defined format from Constants.Hours_Minutes_Seconds.";
			}
			
			if(timeArray.length == 3){
				int hours;
				int minutes;
				int seconds;
				
				try{
				 hours = Integer.parseInt(timeArray[0]);
				}catch(Exception exp){
					return "Please enter hours in integer value range of 0 to 24";
				}
				
				try{
					 minutes = Integer.parseInt(timeArray[1]);
				}catch(Exception exp){
						return "Please enter minutes in integer value range of 0 to 59";
				}
				
				try{
					  seconds = Integer.parseInt(timeArray[2]);
				}catch(Exception exp){
						return "Please enter seconds in integer value range of 0 to 59";
				}
				
				if( hours > 24 || hours < 0){
					return "Please enter hours within range of 0 to 24";
				} 
				
				
				if( minutes > 59 || minutes < 0){
					return "Please enter minutes within range of 0 to 59";
				} 
				
				
				if( seconds > 59 || seconds < 0){
					return "Please enter seconds within range of 0 to 59";
				} 
				
				
				return "Validation Succeed";
				
			}else{
				return "Please enter full time details in "+Constants.Hours_Minutes_Seconds+" format";
			}
			
		}else{
			return "Time should contain : as seperator";
		}
		
		
	}
}
