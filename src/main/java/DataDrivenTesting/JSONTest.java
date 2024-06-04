package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class JSONTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		//Parse JSON file into java Object using JSONParser class
		JSONParser parser = new JSONParser();
	Object obj	=parser.parse(new FileReader("C:\\Users\\thiru\\OneDrive\\Desktop\\ExcelSheetPoi\\AppCommonData.json"));
	          
	//convert JAVAObj to JSON Object
	
		
	JSONObject	map=(JSONObject)obj;
	System.out.println(map.get("url"));
	
	
	
		
	String URL=map.get("url").toString();
	String Browser=map.get("browser").toString();
	String UN=map.get("username").toString();
	String PW=map.get("password").toString();
	
	
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
	   

	wb.close();
	
	
	WebDriver driver =null;
	if(Browser.equals("chrome")) {
		 driver = new ChromeDriver();

	}
	else if(Browser.equals("firefox")) {
		 driver = new FirefoxDriver();

	}
	else {
		 driver = new ChromeDriver();

	}
	
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
		
	}
}
