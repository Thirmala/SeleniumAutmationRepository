package GenericContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericFileUtility.FileUtility;
import GenericWebDriverUtility.JavaUtility;

public class CreateContactWithSupportDate {
	
     @Test
	public void contactWithSupportDate() throws Exception {
		// TODO Auto-generated method stub
		
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();

		String Browser=flib.getDataFromPropertiesFile("browser");
		String URL=	flib.getDataFromPropertiesFile("url");
		String UN=flib.getDataFromPropertiesFile("username");
		String PW=	flib.getDataFromPropertiesFile("password");
				
	
		//READ TESTSCRIPT DATA FROM EXCEL FILE`
		FileInputStream fis1 = new FileInputStream("./testScriptData/OrgTestScript.xlsx");

        Workbook wb =WorkbookFactory.create(fis1);
		
		         Sheet sh=wb.getSheet("org");
                 Row row = sh.getRow(9);
                 String lastName= row.getCell(2).toString();
                 System.out.println(lastName);

		
		WebDriver	 driver = new ChromeDriver();
	
	    driver.manage().window().maximize();
	     driver.get(URL);

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
		Actions action = new Actions(driver);
		

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PW);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

      String todayDate=jlib.getSystemDateYYYYMMDD();
      String ReqDate=jlib.getRequiredDateYYYYMMDD(40);

		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@name=\"support_start_date\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"support_start_date\"]")).sendKeys(todayDate);
		driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).sendKeys(ReqDate);
		String endDate=driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).getText();
		Thread.sleep(20000);
		System.out.println(endDate);
		System.out.println(ReqDate);		
		Assert.assertEquals(endDate, ReqDate, "Both are not matching");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//		String actualStartDate=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();

		

		Thread.sleep(2000);
		

	driver.quit();			

	}

}
