package com.anish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.anish.entity.Car;

public class CarDao {
	
	Connection conn;
	
	public Car addCar(String make, String model, String color, float miles, float price) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Car car=new Car();
		conn=DBConnection.getConnection();
		PreparedStatement pstmt= conn.prepareStatement("insert into Car value(?,?,?,?,?)");
		car.setMake(make);
		car.setModel(model);
		car.setColor(color);
		car.setMiles(miles);
		car.setPrice(price);
		pstmt.setString(1, car.getMake());
		pstmt.setString(2, car.getModel());
		pstmt.setString(3, car.getColor());
		pstmt.setFloat(4, car.getMiles());
		pstmt.setFloat(5, car.getPrice());
		pstmt.execute();
		pstmt.close();
		conn.close();
		return car;
	}
	
	public ResultSet showCars(String make, String model) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		
		conn=DBConnection.getConnection();
		PreparedStatement pstmt= conn.prepareStatement("select * from Car where model="+model);
		ResultSet rst=pstmt.executeQuery();
		
		
		return rst;
	}
}
