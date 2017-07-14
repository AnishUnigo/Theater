package com.anish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class PaymentDAO {
	
	public static boolean execute=true;
	private static Logger log= Logger.getLogger(PaymentDAO.class);

	public static int withdraw(String acc_no, int withdraw) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		log.info("account_no"+acc_no);
		Connection conn= DBConnection.getConnection();
		int balance=0;
		PreparedStatement pstmt= conn.prepareStatement("update account set balance=balance + ? where acc_no=?");
		try{
		
			
		pstmt.setInt(1, withdraw);
		pstmt.setString(2, acc_no);
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		pstmt.executeUpdate();
		
		PreparedStatement pstmt2=conn.prepareStatement("select balance from account where acc_no=?");
		pstmt2.setString(1, acc_no);
		ResultSet rst=pstmt2.executeQuery();
		while(rst.next()){
			balance=rst.getInt(1);
			log.info("balance : "+balance);
		}
		
		log.info("returning balance");
		conn.close();
		return balance;
	}
	
	public int updateBalance(String acc_no, int withdraw) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		log.info("in update Balance");
		System.out.println("in UpdateBalance() of paymentDAO ");
		int currentBalance=0;
		/*while(true){}*/
			
			System.out.println("Account Number : "+acc_no);
			System.out.println("currentbalance"+currentBalance);
			if(execute){
				currentBalance= PaymentDAO.withdraw(acc_no, withdraw);
				log.info("cuurentBalance"+currentBalance);
				
			}
		
		
		return currentBalance;
	}
	
}
