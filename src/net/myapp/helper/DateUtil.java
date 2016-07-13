package net.myapp.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static DateFormat df = new SimpleDateFormat("dd/MM/yy");
	 
	public static  Date getCurrentDateAndTime(){
		Date date = new Date();
		return date;
	}
	
	
	public static  Date findValidTo(Date today,int month){
		int month_from=today.getMonth();
		int month_to=month_from+month;
		today.setMonth(month_to);
		
		return today;
	}
	
}
