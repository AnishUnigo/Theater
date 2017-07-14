package com.anish.core.entity;

public class Theater {
	
	private Address address;
	private String theaterName;
	private int noOfScreens;
	private Screen screen;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	private String[] movies=new String[5];
	
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getNoOfScreens() {
		return noOfScreens;
	}
	public void setNoOfScreens(int noOfScreens) {
		this.noOfScreens = noOfScreens;
	}
	public Theater(){}
		
	public void deleteMovie(String movieName){
		for(int i=0;i<movies.length-1;i++){
			if(this.movies[i]==movieName){
				this.movies[i]=null;
			}
		}
	}
	
	public void addRowsAndSeats(Row rows, Seat seat){
		
		
	}
	
	
	
}
