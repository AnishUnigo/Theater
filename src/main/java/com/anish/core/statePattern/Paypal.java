package com.anish.core.statePattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.anish.core.dao.DBConnection;
import com.anish.core.model.CodeSnippets;


public class Paypal implements Payment {
	private static Logger log=Logger.getLogger(Paypal.class);
	Connection conn;
	public boolean processPayment(PaymentContext context) {
		boolean isExecuted=false;
		String shaPassword=CodeSnippets.getSha256(context.getPassword());
		
		log.info("In paypal acc_no : "+context.getAcc_no());
		log.info("In paypal password : "+shaPassword);
		try {
			conn=DBConnection.getConnection();
		}catch (InstantiationException e) {e.printStackTrace();
		}catch (IllegalAccessException e) {e.printStackTrace();
		}catch (ClassNotFoundException e) {e.printStackTrace();
		}catch (SQLException e) {e.printStackTrace();
		}
		String sql="insert into account (acc_no,password) values(?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, context.getAcc_no());
			pstmt.setString(2, shaPassword);
			log.info(pstmt.execute());
			isExecuted=true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		context.setPayment(this);
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExecuted;
	}
	
	public  boolean update(PaymentContext context) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		{
		boolean executeResult=false;
		String shaPassword=CodeSnippets.getSha256(context.getPassword());
		Connection conn= DBConnection.getConnection();
		int balance=0;
		log.info("price : "+context.getAmount());
		log.info("Account Number : "+context.getAcc_no());
		PreparedStatement pstmt= conn.prepareStatement("update account set balance=balance - "+context.getAmount()+" where acc_no=? and password=?");
		try{			
			
			pstmt.setString(1, context.getAcc_no());
			pstmt.setString(2, shaPassword);
			log.info("execute Update : "+pstmt.executeUpdate());
			if(pstmt.executeUpdate()==1){
			
			executeResult=true;
			
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
			
		PreparedStatement pstmt2=conn.prepareStatement("select balance from account where acc_no=? ");
		pstmt2.setString(1, context.getAcc_no());
		ResultSet rst=pstmt2.executeQuery();
		while(rst.next()){
			balance=rst.getInt(1);
			log.info("balance"+balance);
		}
	
		conn.close();
		return executeResult;
	}
	}

}
