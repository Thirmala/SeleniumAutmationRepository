package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class JDBCWithTestScript {

	@Test
	public void projectCheckTest() throws Exception{
		String expectedProjectName ="FB_01";
		boolean flag = false;
		Connection con= null;
		//if there is mistake in Query or connecting with invalid UN or PS or URL exception (CONTINUES DOWN)
		//occurs and connection will not get closed so handle the exception using TRY & CATCH
		//Close the connection in finally(if exception or not the connection get closed)
		try {
        Driver loadDriver = new Driver();	
		DriverManager.registerDriver(loadDriver);
		 con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		  ResultSet res = con.createStatement().executeQuery("select * from project");
		  System.out.println(res); 
		  while(res.next()) {
			  String actProjName =  res.getString(4);
                 if(actProjName.equals(expectedProjectName))	{
	                 flag =true;
	             System.out.println(expectedProjectName+ "is available in DB");
}
		 }
		  if(flag==false) {
			  System.out.println(expectedProjectName+ "is not available in DB");
			  //even though project is not available it shows NO FAILURE OCCURED OR (failure 0) in Console 
			  //to overcome this
			  Assert.fail(); 
		  }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(" exception is handled");
		}
		finally {
			con.close();
			System.out.println("connection is closed");
		}
		 
}
}
