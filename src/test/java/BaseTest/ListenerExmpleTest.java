package BaseTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ListenerUtility.BaseClass;

public class ListenerExmpleTest  extends BaseClass  {
	
	@Test
	public void homePageCheck() {
		
		System.out.println("Login is Successfull, Home page is displyed");
		String actTitle =driver.getTitle();
		
		
		//after login HomePage is Displayed but we are passing Login
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
	}
	
	
	@Test
	public void createInvoiceWithContactTest() {
		
		System.out.println("execute createInvoiceWithContactTest");
		System.out.println("step-1");
	}


}
