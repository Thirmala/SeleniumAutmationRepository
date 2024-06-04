package DataDrivenTesting;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OrganizationName {

		public static void main(String[] args) throws Exception {
			
			FileInputStream fis = 
					new FileInputStream("C:\\Users\\thiru\\OneDrive\\Desktop\\ExcelSheetPoi\\commondata.properties");
			
				Properties pobj = new Properties();
				pobj.load(fis);
				
			String Browser=pobj.getProperty("browser");
			String URL=pobj.getProperty("url");
			String UN=pobj.getProperty("username");
			String PW=pobj.getProperty("password");
			
			//generate random number
			
			Random random = new Random();
			int randomInt= random.nextInt(1000);
			
			//READ TESTSCRIPT DATA FROM EXCEL FILE
			
			
			FileInputStream fis1 = new FileInputStream("C:\\Users\\thiru\\OneDrive\\Desktop\\ExcelSheetPoi\\OrgTestScript.xlsx");
			
			Workbook wb =WorkbookFactory.create(fis1);
			
			   Sheet sh = wb.getSheet("org");
			   
		    Row row=  sh.getRow(4);
			    //row 5 means index 4
			    
	        //get the control of 2nd Cell & read String Data
		       Cell cell =row.getCell(2);
		       //** add random int variable to get random number for orgname
			   String orgName =cell.getStringCellValue() + randomInt ;  
			   
//			   cell.setCellType(CellType.STRING);
//			   cell.setCellValue(orgName);
			    
//			System.out.println(orgName);
			wb.close();
			
			
			
				WebDriver driver = new ChromeDriver();

			
		    driver.manage().window().maximize();
		     driver.get(URL);

		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    
			
			Actions action = new Actions(driver);

			driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
			driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PW);
			driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			
			driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
			
			WebElement accName=driver.findElement(By.xpath("//input[@name=\"accountname\"]"));
			//accName.sendKeys(orgName);
			Thread.sleep(2000);

			action.moveToElement(accName).click().sendKeys(orgName).perform();
Thread.sleep(2000);

		driver.quit();			
			
		}
	

}
