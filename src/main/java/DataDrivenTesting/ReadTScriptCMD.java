//package DataDrivenTesting;
//
//import java.io.FileInputStream;
//import java.time.Duration;
//import java.util.Properties;
//import java.util.Scanner;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//
//public class ReadTScriptCMD {
//	
//	@Test
//	   public void seleniumTest() throws Exception{
//		
//			
////		String Browser=
////		String URL=
////		String UN=
////		String PW=
//		
//		  Scanner s = new Scanner(System.in);
//			System.out.println("enter the Browser");
//		 	String Browserr=s.next();
//			System.out.println(Browserr);
//			WebDriver driver =null;
//			if(Browserr.equals("chrome")) {
//				 driver = new ChromeDriver();
//
//			}
//			else if(Browserr.equals("firefox")) {
//				 driver = new FirefoxDriver();
//
//			}
//			else {
//				 driver = new ChromeDriver();
//
//			}
//			
//		    driver.manage().window().maximize();
//		     driver.get(URL);
//
//		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		    
//			
//			Actions action = new Actions(driver);
//
//			driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
//			driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PW);
//			driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
//		
//	}
//		
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	}
//
//}
