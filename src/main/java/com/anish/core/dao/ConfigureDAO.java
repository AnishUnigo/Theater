package com.anish.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*import com.anish.core.entity.Seat;*/
import com.anish.core.entity.Theater;

public class ConfigureDAO {
	
	private Connection conn;
	public boolean addTheater(Theater theater) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		boolean isExecuted=false;
		conn=DBConnection.getConnection();
		
		int noOfScreens = theater.getNoOfScreens();
		System.out.println("No of Screens in DAO : "+noOfScreens);
		System.out.println("Nof of rows in DAO : "+theater.getScreen().getNoOfRows());
		System.out.println("Nof of seats per rows  in DAO : "+theater.getScreen().getNoOfSeats());
		System.out.println("Theater Name in DAO "+theater.getTheaterName());
		String sql="insert into screen (theaterName, screenId , rowId , seatId, rowsAndSeats, availability) value(?,?,?,?,?,?)";
		String alphabet=null;
		String name=theater.getTheaterName();
		PreparedStatement pstmt=null;
		
		try{
			
			for(int h=1; h<=noOfScreens;h++){
				System.out.println("Screen No : "+h);
				for(int i=1; i<=theater.getScreen().getNoOfRows(); i++){
					System.out.println("row number : "+i+" row id :"+getCharForNumber(i));
					for(int j=1; j<=theater.getScreen().getNoOfSeats(); j++){
						
						System.out.println("screen no : "+h+", row id: "+getCharForNumber(i)+", seat id : "+j);
						alphabet= getCharForNumber(i);
						String rowsAndSeats=alphabet+j;
						pstmt= conn.prepareStatement(sql);
						pstmt.setString(1,name);
						pstmt.setInt(2,h);
						pstmt.setString(3,alphabet);
						pstmt.setInt(4,j);
						pstmt.setString(5, rowsAndSeats);
						pstmt.setBoolean(6,true);
						
						pstmt.execute();
					}
				}
			}
			
			isExecuted=pstmt.execute();
		}catch(Exception e){e.printStackTrace();}
		
		conn.close();
		
		return isExecuted;
	}
	
	public Set<String> getRows(int screenId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Set<String> setRow= new TreeSet<String>();
		String sql= "select rowId from screen where screenId="+screenId;
		conn=DBConnection.getConnection();
		
		PreparedStatement pstmt= conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		while(rst.next()){
			
			String rowId=rst.getString(1);
			setRow.add(rowId);
		}
		return setRow;
	}
	public void getSeats(int screenId) throws SQLException{
		
		List<Integer> listOfSeats=new ArrayList<Integer>();
		/*Seat seat=new Seat();*/
		
		String sql= "select rowId,seatId, availability from screen where screenId="+screenId;
		PreparedStatement pstmt= conn.prepareStatement(sql);
		
		ResultSet rst=pstmt.executeQuery();
		while(rst.next()){
			
			int seatNo= rst.getInt(2);
			listOfSeats.add(seatNo);
			
		}
	}
	
	private String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
}
