package com.anish.core.entity;


public class Address {
	private int doorNumber;
	private String street;
	private String city;
	private String state;
	private long zipCode;
	public static final String country="USA";
	
	public int getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	
	public boolean equales(Address adrs){
		
		if(this.getDoorNumber()==adrs.getDoorNumber()){
			
			return true;
			
		}else{
			return false;
		}
	}
}
