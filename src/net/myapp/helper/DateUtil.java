package net.myapp.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private  static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	public static  Date getCurrentDateAndTime(){
		Date date = new Date();
		return date;
	}
	
	
	public static  Date addMonth(int monthCount){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthCount);
		return calendar.getTime();
	}
	
}
