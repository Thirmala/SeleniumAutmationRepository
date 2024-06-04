package GenericOrgTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry  {
	
	public static void main(String[] args) throws Throwable, Exception {
		FileInputStream fis = new FileInputStream("./CommonData/commondata.properties");
		
			Properties pobj = new Properties();
			pobj.load(fis);
		String Browser=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String UN=pobj.getProperty("username");
		String PW=pobj.getProperty("password");
		
		//generate random number
		
		Random random = new Random();
		int randomInt= random.nextInt(1000);
		
		//READ TESTSCRIPT DATA FROM EXCEL FILE`
		FileInputStream fis1 = new FileInputStream("./testScriptData/OrgTestScript.xlsx");

        Workbook wb =WorkbookFactory.create(fis1);
		
		         Sheet sh=wb.getSheet("org");
                 Row row = sh.getRow(4);
                 String orgName= row.getCell(2).toString() + randomInt;
                 String industry= row.getCell(3).toString();
                 String type   = row.getCell(4).toString();

		
		WebDriver	 driver = new ChromeDriver();

		
	    driver.manage().window().maximize();
	     driver.get(URL);

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
		
		Actions action = new Actions(driver);

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PW);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
WebElement INDUSTRY=driver.findElement(By.xpath("//select[@name=\"industry\"]"));
      
Select selIndustry = new Select(INDUSTRY);

selIndustry.selectByVisibleText(industry);//select from Excel sheet
         

         WebElement TYPE=driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));
         Select selType = new Select(TYPE);

         
         selType.selectByVisibleText(type);
         
         //Organization Information Created
     String  createdIndustry = driver.findElement(By.xpath("(//td[@class=\"dvtCellLabel\"])[13]")).toString();
     
     
     
     //Do Verification for Organization Information
     if(createdIndustry.equals(industry)) {
    	 System.out.println("Energy is succesfully created in Industry column");
     }
     else {
    	 System.out.println("Energy is succesfully created in Industry column");

     }
     String  createdType = driver.findElement(By.xpath("(//td[@class=\"dvtCellLabel\"])[15]")).toString();

     if(createdType.equals(type)) {
    	 System.out.println("Press is succesfully created in Type column");
     }
     else {
    	 System.out.println("Press is succesfully created in Type column");

     }


	driver.quit();			
	}

}
