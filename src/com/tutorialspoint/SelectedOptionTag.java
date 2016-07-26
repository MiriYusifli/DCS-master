package com.tutorialspoint;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.Map;

public class SelectedOptionTag extends SimpleTagSupport {
	private Map<String,String>  options;
	String filtr;
	
	
  public Map<String, String> getOptions() {
		return options;
	}


	public String getFiltr() {
		return filtr;
	}
  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
    for (Map.Entry entry : options.entrySet()) {
		out.println("<td>"+entry.getValue()+"</td>");
	}
    //out.println("Hello Custom Tag!");
  }
}