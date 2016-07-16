package net.myapp.helper.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DataUtilIntParameter {

	
	
	static List <Integer>  hbrParameterList=new ArrayList<>();
	public static void clean(){
		hbrParameterList=new ArrayList<>();
	}
	public static void add(Integer parametr){
		hbrParameterList.add(parametr);
	}
	
	
	
	public static void setParameter(Query query){
		int i=0;
		
		for (Integer s : hbrParameterList) {
			query.setParameter(i, s);
			i++;
		}
	}
	
	
	
	
	
}
