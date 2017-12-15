package com.tavant.main;

import java.util.Comparator;
import java.util.Date;

public class DayCounter implements Comparator {

	public int compare(Object arg0, Object arg1) {
		Date currentDate = (Date)arg0;
		Date initiationDate = (Date) arg1;
		
		int totalDaysOfCuurentDate = 365*currentDate.getYear() + currentDate.getYear()/4 - currentDate.getYear()/100 + currentDate.getYear()/400 + currentDate.getDay() + (153*currentDate.getMonth()+8)/5; 
		int totalDaysOfInitiationDate =  365*initiationDate.getYear() + initiationDate.getYear()/4 - initiationDate.getYear()/100 + initiationDate.getYear()/400 + initiationDate.getDay() + (153*initiationDate.getMonth()+8)/5;
		//System.out.println("diff = "+ (totalDaysOfCuurentDate - totalDaysOfInitiationDate));
		return totalDaysOfCuurentDate - totalDaysOfInitiationDate;
	}

}
