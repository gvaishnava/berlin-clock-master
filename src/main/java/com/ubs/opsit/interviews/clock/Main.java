package com.ubs.opsit.interviews.clock;

import java.util.Scanner;

import com.ubs.opsit.interviews.clock.constants.Constants;
import com.ubs.opsit.interviews.clock.factory.ClockFactory;
import com.ubs.opsit.interviews.clock.impl.BerlinClock;


/**
 * @author Gaurav
 * Application entry point
 * It takes input time in HH:MM:SS format and convet in berlin time.
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputTime = "05:30:03";
		
		System.out.println("Enter time in HH:MM:SS format to convert in Berlin Time");
		
		Scanner scan = new Scanner(System.in);
		inputTime = scan.next();
		
		// ClockFactory to generate clock of desired type,
		// Factory instance to hide implementaion detail from User.
		Clock clock = ClockFactory.getBerlinClock();
		
		String output = clock.getDateTime(inputTime, Constants.Hours_Minutes_Seconds);
		System.out.println("For input Time "+inputTime+ " the converted Berlin Time is \n"+output);
	}
}
