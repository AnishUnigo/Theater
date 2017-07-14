package com.anish.core.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.anish.core.controller.BookingController;
import com.anish.core.dao.DBConnection;

public class BookingModel {
	
	private Connection conn;
	private static Logger log=Logger.getLogger(BookingController.class);
	public Map<String,Boolean> getRowsAndSeats(int screenId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Map<String,Boolean> rowsAndSeats=new TreeMap<String,Boolean>();
		conn=DBConnection.getConnection();
		/*Integer[] seat=new Integer[10];*/
		String sql= "select rowsAndSeats , availability from screen where screenId="+screenId;
		
		PreparedStatement pstmt= conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next()){
			String ras=rst.getString(1);
			log.info(ras);
			boolean availability=rst.getBoolean(2);
			rowsAndSeats.put(ras, availability);
		}	
		conn.close();
		return rowsAndSeats;
	}
	
	public boolean bookSeats(String[] split,int screenId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		conn=DBConnection.getConnection();
		boolean executeResult=false;
		String sql;
		PreparedStatement pstmt=null;
		try{
			for(int i=0;i<=split.length-1;i++){
				sql="update screen set availability=0 where rowsAndSeats='"+split[i]+"' and screenid="+screenId+"";
				pstmt=conn.prepareStatement(sql);
				pstmt.execute();
				
			}
			executeResult=true;
			
		}catch(Exception e){e.printStackTrace();}
		
		conn.close();
		
		return executeResult;
	}
	
	public boolean bookTickets(int screenId, String confirmationNumber,int price,String bookedTickets) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		boolean isExecuted=false;
		String sql="insert into ticket (screenId,confirmationNumber,ticketsPrice, bookedTickets) value(?,?,?,?)";
		conn=DBConnection.getConnection();
		try{
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, screenId);
		pstmt.setString(2, confirmationNumber);
		pstmt.setInt(3, price);
		pstmt.setString(4, bookedTickets);
		pstmt.execute();
		isExecuted=true;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return isExecuted;
	}
}
