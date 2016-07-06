package net.myapp.helper;

public class CommonUtil {
	
	public static boolean isNullOrEmpty(String s) {
		if (s==null)  return true;
		else if (s.equals("null"))  return true;
		return false;
		
	}
	public static boolean isNull(Object o) {
		if (o==null)  return true;
		return false;
		
	}
	
	public static boolean isEmail(String s){
		int intIndex = s.indexOf("@");
		if(intIndex != - 1)  return true;
	    return false;
	    
	}
	
}
