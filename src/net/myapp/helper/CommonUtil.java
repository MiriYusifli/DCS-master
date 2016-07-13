package net.myapp.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonUtil {
	
	public static boolean isNullOrEmpty(String s) {
		if (s==null)  return true;
		else if (s.equals(""))  return true;
		return false;
		
	}
	public static boolean isNull(Object o) {
		if (o==null)  return true;
		return false;
		
	}
	public static boolean isNullOr_null(String s) {
		if (s==null)  return true;
		else if (s.equals("null"))  return true;
		return false;
		
	}
	public static boolean isEmail(String s){
		int intIndex = s.indexOf("@");
		if(intIndex != - 1)  return true;
	    return false;
	    
	}
	
	
	public static  boolean isEmpty(List<?> list){
		if (list==null)  return true;
		else if (list.size()==0)  return true;
		return false;
	}
	
	
	
}
