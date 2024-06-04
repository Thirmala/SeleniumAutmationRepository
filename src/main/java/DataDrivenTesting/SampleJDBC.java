package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class SampleJDBC {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub
		Driver loadDriver = new Driver();
		
		//STEP 1: LOAD THE DATA BASE DRIVER
		//Manually we can load the MySQLdriver by SQL command line
		//way To do in Selenium Automation
		
		DriverManager.registerDriver(loadDriver);
		//DriverManager will load or register the load driver
		
		Connection con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		//create SQL  statement SELECT Query
		
		  ResultSet res = con.createStatement().executeQuery("select *from project");
		 System.out.println(res);
		 
		 while(res.next()) {
			 
			 String result =
					 
		  (res.getString(1)+ "  " + res.getString(2) +"  " +res.getString(3)+"  " +
			 
		  res.getString(4)+"  " + res.getString(5)+"  " + res.getString(6));
			 
		  System.out.println(result); System.out.println();
		  
		  }
		 
//			//create SQL  statement INSERT Query
//		 int result = con.createStatement().executeUpdate("insert into project values('TY_PROJ_2006', 'DEEPAK','04/27/2023', 'FB-04', 'Cpmpleted', '5')");
//		 System.out.println(result);


	}

}
