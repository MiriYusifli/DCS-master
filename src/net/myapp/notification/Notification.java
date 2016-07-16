package net.myapp.notification;

import net.myapp.common.web.holders.RequestHelper;

public class Notification {
	protected String notification;//for log
	protected String i18nNotfMessageKey;
	protected String i18nNotfMessageArg;
	
	
	
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String geti18nNotfMessageKey() {
		return i18nNotfMessageKey;
	}
	public void seti18nNotfMessageKey(String i18nNotfMessageKey) {
		this.i18nNotfMessageKey = i18nNotfMessageKey;
	}
	public String geti18nNotfMessageArg() {
		return i18nNotfMessageArg;
	}
	public void seti18nNotfMessageArg(String i18nNotfMessageArg) {
		this.i18nNotfMessageArg = i18nNotfMessageArg;
	}
	
	public String getMessage() {
		return this.getNotification();
	} 
	
	
	public void addErrorKeyArgToRequestHelper() {
		RequestHelper.setAttribute("ErrorKey", this.geti18nNotfMessageKey());
		RequestHelper.setAttribute("ErrorArg", this.geti18nNotfMessageArg());
	}

	
	
}
