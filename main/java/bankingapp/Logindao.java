package bankingapp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;



public class Logindao {
	public boolean getUserName(String username) {
		PreparedStatement ps = null;
		
		List<String> Users  = new ArrayList <String>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USERCREDS";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String name = rs.getString("USERID");
				Users.add(name);
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if(Users.contains(username)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getPassword(String username) {
		PreparedStatement ps = null;
		
		String Password = "";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USERCREDS where USERID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				 Password = rs.getString("USERPW");
				
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return Password;
	}
	
	public float getCheckingAmount(String username) {
		PreparedStatement ps = null;
		
		float result = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT AMOUNT FROM CHECKINGACCOUNT where USERID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				 result = rs.getFloat("Amount");
				 
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return result;
	}
	
	public int getTheCheckingAmountNumber(String username) {
		PreparedStatement ps = null;
		
		int result = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT CHECKINGACCOUNTNUMBER FROM CHECKINGACCOUNT where USERID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				 result = rs.getInt("CheckingAccountNumber");
				 
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return result;
	}
	
	public int getWithdrawlAmount(String username) {
		PreparedStatement ps = null;
		
		int withdrawamount = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT AMOUNT FROM CHECKINGACCOUNT where USERID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				 withdrawamount = rs.getInt("CheckingAccountNumber");
				 
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return withdrawamount;
	}
	public String getFirstName(String username) {
		PreparedStatement ps = null;
		
		String FirstName = "";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT FIRSTNAME FROM USERCREDS where USERID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				 FirstName = rs.getString("FIRSTNAME");
				
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return FirstName;
	}
	
	public String getLastName(String username) {
		PreparedStatement ps = null;
		
		String LastName = "";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT LASTNAME FROM USERCREDS where USERID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				 LastName = rs.getString("LASTNAME");
				
				
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return LastName;
	}
}
	