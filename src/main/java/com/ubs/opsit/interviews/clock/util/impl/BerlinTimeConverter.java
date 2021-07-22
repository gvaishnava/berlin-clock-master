package com.ubs.opsit.interviews.clock.util.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ubs.opsit.interviews.clock.util.TimeConverter;
import com.ubs.opsit.interviews.clock.util.TimeValidator;

/**
 * @author Gaurav
 * TimeConverte implementation for BerlinTime
 */
public class BerlinTimeConverter implements TimeConverter {

	
	/**
	 *  Constructor
	 */
	public BerlinTimeConverter(){
		
	}
	
	
	/* (non-Javadoc)
	 * Convert time to Berlin Time
	 * @see com.ubs.opsit.interviews.clock.util.TimeConverter#convertTime(java.lang.String)
	 */
	@Override
	public String convertTime(String time){			
			return String.join(System.getProperty("line.separator"), convertToBerlinTime(time));
	}

	
	private String[] convertToBerlinTime(String time) {
		List<Integer> parts = new ArrayList<Integer>();
		for (String part : time.split(":")) {
		  parts.add(Integer.parseInt(part));
		}
		
		
		 Integer[] partsInt = new Integer[3];
		 parts.toArray(partsInt);
		
		return new String[] {
                getSeconds(partsInt[2]),
                getTopHours(partsInt[0]),
                getBottomHours(partsInt[0]),
                getTopMinutes(partsInt[1]),
                getBottomMinutes(partsInt[1])
        };
    }
 
    private String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }
 
    private String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }
 
    private String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }
 
    private String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }
 
    private String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }
 
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }
 
    private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
    }
    
  
}
