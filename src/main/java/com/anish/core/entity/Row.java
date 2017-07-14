package com.anish.core.entity;

import java.util.ArrayList;
import java.util.Map;


public class Row {
	
	private Map<String, Seat> seats;
	
	private ArrayList<String> row;

	public Map<String, Seat> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, Seat> seats) {
		this.seats = seats;
	}

	public ArrayList<String> getRow() {
		return row;
	}

	public void setRow(ArrayList<String> row) {
		this.row = row;
	}

	
}
