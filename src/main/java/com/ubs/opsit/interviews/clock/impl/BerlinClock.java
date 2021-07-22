package com.ubs.opsit.interviews.clock.impl;

import com.ubs.opsit.interviews.clock.Clock;
import com.ubs.opsit.interviews.clock.util.TimeConverter;
import com.ubs.opsit.interviews.clock.util.TimeValidator;
import com.ubs.opsit.interviews.clock.util.impl.BerlinTimeConverter;
import com.ubs.opsit.interviews.clock.util.impl.BerlinTimeValildator;

/**
 * @author Gaurav
 * BerlinClock implementation, A SingleTon instace of BerlinClock,
 * As we do not maintain any state of Clock so we are making it as Singleton
 */
public class BerlinClock implements Clock{

	private static Clock clk = new BerlinClock();
	private TimeConverter timeconverter = null;
	private TimeValidator timevalidator = null;
	
	
	/**
	 * Constructor
	 */
	private BerlinClock(){
		timeconverter = new BerlinTimeConverter();
		timevalidator = new BerlinTimeValildator();
	}
	
	
	/**
	 * This method is synchronized to make it thread safe.
	 * @return Singleton clock object
	 */
	public synchronized static Clock getInstance(){
		return clk;
	}
	

	/* (non-Javadoc)
	 * DateTime method to perform validation on input time and return conveted berlin time
	 * @see com.ubs.opsit.interviews.clock.Clock#getDateTime(java.lang.String, java.lang.String)
	 */
	@Override
	public String getDateTime(String time,String timeformat){
				
        String validationResult = timevalidator.validateTime(time, timeformat);
		
		if(validationResult.equalsIgnoreCase("Validation Succeed")){
			return String.join(System.getProperty("line.separator"), timeconverter.convertTime(time));
		}else{
			return validationResult;
		}
		
		
	}
	
	

    
}
