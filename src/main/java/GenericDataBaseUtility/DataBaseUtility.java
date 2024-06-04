package GenericDataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	
	public void getDbConnection() throws Exception {
		try {
			
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%", "root");

		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getDbConnection(String url, String username, String password) throws Exception {
		try {
			
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		con =DriverManager.getConnection(url, username, password );

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}	
		public void closeDbconnection() throws Exception {
			con.close();
		
		
	}
		
		public ResultSet executeSelectQuery(String query) throws Exception {
			ResultSet result =null;
			//IF QUERY IS WRONG 
			try {
			Statement stat =con.createStatement();
			
			 result=stat.executeQuery(query);

			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return result;		
		}
		

		public int  executeNonSelectQuery(String query) throws Exception {
			int result=0 ;
			//IF QUERY IS WRONG we have handle the exception
			try {
			Statement stat =con.createStatement();
			
			 result=stat.executeUpdate(query);

			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return result;

			
		
		}
		

}
