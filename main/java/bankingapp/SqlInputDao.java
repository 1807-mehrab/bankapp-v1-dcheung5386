package bankingapp;
import java.sql.CallableStatement;
import java.sql.Connection;


public class SqlInputDao {
	public void withdrawSQL(String USERID, double amt) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_WITHDRAW_ACCOUNT(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setString(1, USERID);
			cs.setDouble(2, amt);
			
			
			Boolean result = cs.execute();
			if (!result) {
				System.out.println("Withdraw Succeeded");
			} else {
				System.out.println("Failed");
			}
			
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		public void depositSQL(String USERID, double amt) {
			CallableStatement cs = null;
			
			try(Connection conn = ConnectionUtil.getConnection()) {
				String sql = "{CALL SP_DEPOSIT_ACCOUNT(?,?)}";
				cs = conn.prepareCall(sql);
				cs.setString(1, USERID);
				cs.setDouble(2, amt);
				
				
				Boolean result = cs.execute();
				if (!result) {
					System.out.println("Deposit Succeeded");
				} else {
					System.out.println("Failed");
				}
				
				cs.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
}
		public void newAccount (String newUsername, String newPW, String newFirstname, String newLastname) {
			CallableStatement cs = null;
			
			try(Connection conn = ConnectionUtil.getConnection()) {
				String sql = "{CALL SP_CREATE_ACCOUNT(?,?,?,?)}";
				cs = conn.prepareCall(sql);
				cs.setString(1, newUsername);
				cs.setString(2, newPW);
				cs.setString(3, newFirstname);
				cs.setString(4, newLastname);
				
				
				Boolean result = cs.execute();
				if (!result) {
					System.out.println("Create Succeeded");
				} else {
					System.out.println("Failed");
				}
				
				cs.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
}
	
}
