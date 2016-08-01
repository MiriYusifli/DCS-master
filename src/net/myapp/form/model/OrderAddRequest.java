package net.myapp.form.model;

public class OrderAddRequest extends MainRequest {
	int good_id;
	int gcount;
	
	public int getGood_id() {
		return good_id;
	}
	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}
	public OrderAddRequest(int good_id, int gcount) {
		super();
		this.good_id = good_id;
		this.gcount = gcount;
	}
	public int getGcount() {
		return gcount;
	}
	public void setGcount(int gcount) {
		this.gcount = gcount;
	}
	
}
