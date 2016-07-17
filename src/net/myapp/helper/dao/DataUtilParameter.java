package net.myapp.helper.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DataUtilParameter {

	
	
	static List <Object>  hbrParameterList=new ArrayList<>();
	public static void clean(){
		hbrParameterList=new ArrayList<>();
	}
	public static void add(String parametr){
		hbrParameterList.add(parametr);
	}
	public static void add(int parametr){
		hbrParameterList.add(String.valueOf(parametr));
	}
	
	
	public static void setParameter(Query query){
		int i=0;
		
		for (Object object : hbrParameterList) {
			query.setParameter(i, object);
			i++;
		}
	}
	
	
	
	
	
}
