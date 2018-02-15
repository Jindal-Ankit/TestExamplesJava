package com.ankit.practice.problems;

public class TimeTaken {

	long startTime ;
	
	public void captureStartTime(){
		this.startTime = System.nanoTime();
	}
	
	public void  calculateTimeTakeninSec(){
		long endTime = System.nanoTime();
		if(startTime  <= 0 || (endTime - startTime) <= 0) 
			throw new RuntimeException("Start time not captured. Please call capure starttime method." + endTime +" :: " + startTime);
		
		System.out.println("Total running time is : " + (endTime - startTime)/100000.0 + " milli-sec");
	}
}
