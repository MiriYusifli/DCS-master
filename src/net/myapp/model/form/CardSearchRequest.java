package net.myapp.model.form;

public class CardSearchRequest extends MainRequest {
String pin_email="";
String code="";
public String getPin_email() {
	return pin_email;
}
public void setPin_email(String pin_email) {
	this.pin_email = pin_email;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}

}
