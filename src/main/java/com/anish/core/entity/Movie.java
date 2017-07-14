package com.anish.core.entity;

import java.sql.Connection;
import java.sql.SQLException;

public class Movie {
	
	private int movieId;
	private String movieName;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public void addMovie(Connection conn, Screen screen, String MovieName) throws SQLException{
		
		/*String query="Insert into movie values(?,?,?)";
		PreparedStatement pstmt= (PreparedStatement)conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, movieId);
		pstmt.setString(2, movieName);
		pstmt.setInt(3, screen.getScreenId());
		pstmt.execute();
		String sql="select * from movie where movieName="+MovieName;
			
		System.out.println("You have booked tickets for movie : "+MovieName);
		
		pstmt.close();
*/		
	}
}
