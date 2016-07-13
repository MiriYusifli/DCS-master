package net.myapp.validity.user;

public class UserValidity {

	public static boolean checkPin(String str) {
	 if (str.length()==7)  return true;   
	 return false;
	}
	
}
