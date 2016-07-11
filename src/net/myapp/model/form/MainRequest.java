package net.myapp.model.form;

public class MainRequest {
String ok="null";

public String getOk() {
	return ok;
}

public void setOk(String ok) {
	this.ok = ok;
}

public boolean isNotNullSubmitOk(){
	if (!this.ok.equals("null")) return true;
	return false;
}

}
