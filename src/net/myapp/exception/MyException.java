package net.myapp.exception;

import net.myapp.common.web.holders.RequestHelper;

public class MyException extends Exception {
	   protected String errorDescription;//for log
	   protected String i18nErrorMessageKey;
	   protected String i18nErrorMessageArg;
	   
	 /*  public MyException(String errordescription, String i18nErrorMessageKey) {
		super();
		this.errordescription = errordescription;
		this.i18nErrorMessageKey = i18nErrorMessageKey;
	}*/
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription =errorDescription;
	}
	public String getI18nErrorMessageKey() {
		return i18nErrorMessageKey;
	}
	public void setI18nErrorMessageKey(String i18nErrorMessageKey) {
		this.i18nErrorMessageKey = i18nErrorMessageKey;
	}
	public String getI18nErrorMessageArg() {
		return i18nErrorMessageArg;
	}
	public void setI18nErrorMessageArg(String i18nErrorMessageArg) {
		this.i18nErrorMessageArg = i18nErrorMessageArg;
	}
	   
	@Override
	public String getMessage() {
		return this.getErrorDescription();
	} 
	
	
	public void addErrorKeyArgToRequestHelper() {
		RequestHelper.setAttribute("ErrorKey", this.getI18nErrorMessageKey());
		RequestHelper.setAttribute("ErrorArg", this.getI18nErrorMessageArg());
	}

}
