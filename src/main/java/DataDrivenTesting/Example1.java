package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example1 {
public static void main(String[] args) throws Exception {
	FileInputStream fis = 
			new FileInputStream("C:\\Users\\thiru\\OneDrive\\Desktop\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
	String Browser=pobj.getProperty("browser");
	String URL=pobj.getProperty("url");
	String UN=pobj.getProperty("username");
	String PW=pobj.getProperty("password");
	
	Scanner s = new Scanner(System.in);
	System.out.println("enter the Browser");
 	String Browserr=s.next();
	System.out.println(Browserr);
	WebDriver driver =null;
	if(Browserr.equals("chrome")) {
		 driver = new ChromeDriver();

	}
	else if(Browserr.equals("firefox")) {
		 driver = new FirefoxDriver();

	}
	else {
		 driver = new ChromeDriver();

	}
	
    driver.manage().window().maximize();
    driver.get("https://demowebshop.tricentis.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    
	
//	driver.get(URL);
	

	driver.findElement(By.xpath("//a[text()='Log in']")).click();
	driver.findElement(By.id("Email")).sendKeys(UN);
	driver.findElement(By.id("Password")).sendKeys(PW);
	driver.findElement(By.xpath("//a[text()='Log in']")).click();


driver.quit();

	
	
}
}
