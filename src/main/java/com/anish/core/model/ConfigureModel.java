package com.anish.core.model;

import java.sql.SQLException;
import java.util.Map;

import com.anish.core.dao.ConfigureDAO;

import com.anish.core.entity.Theater;

public class ConfigureModel {
	
	public boolean addTheater(Theater theater) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		boolean isExecuted=false;
		ConfigureDAO dao=new ConfigureDAO();
		try{
			
			isExecuted= dao.addTheater(theater);
			System.out.println("in addTheater of configureModel : "+isExecuted);
			
		}catch(Exception e){e.printStackTrace();}
		
		return isExecuted;
	}
	
	public Map<String,Integer> getRowsAndSeats(){
		
		/*ConfigureDAO dao=new ConfigureDAO();*/
		
		return null;
	}
	public void addRows(int noOfRows){
		/*Row row=new Row(); */
		
	}
	
	public void addSeats(int noOfSeats){
		
	}
}
