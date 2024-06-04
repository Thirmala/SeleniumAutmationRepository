package GenericOrgTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericFileUtility.ExcelUtility;
import GenericFileUtility.FileUtility;
import GenericWebDriverUtility.JavaUtility;
import ObjectRepository.CreatingNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;

public class DeleteOrgTest  {
	
	public static void main(String[] args) throws Exception {
	

		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		
		
		//read Common Data from JSON file
		String Browser=flib.getDataFromPropertiesFile("browser");
	String URL=	flib.getDataFromPropertiesFile("url");
	String UN=flib.getDataFromPropertiesFile("username");
	String PW=	flib.getDataFromPropertiesFile("password");
		
		

	//READ TESTSCRIPT DATA FROM EXCEL FILE from a Cell and Provide randomNumber
			String orgName = elib.getDataFromExcel("org", 9, 2)+ jlib.getRandomNumber();
	
	
	WebDriver driver = new ChromeDriver();

	
    driver.manage().window().maximize();
     driver.get(URL);

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    
	
	Actions action = new Actions(driver);
	//lazy initialization
	LoginPage lp =	new LoginPage(driver);

	//lp.login("admin", "admin");
	
	
	
	HomePage hp = new HomePage(driver);
	
	
	hp.getOrgLink().click();;
	
	
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	
	oip.getCreateNewOrgBtn().click();
	
	
	CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
	cop.createOrg(orgName);
	
	
	//logout home page
//	hp.logout();
	


String OrginfoHeader =driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();

  if(OrginfoHeader.contains(orgName)) {
       System.out.println("Organization information Header is created");
   }
  
  else {
       System.out.println("Organization information Header is not created");

  }
  Thread.sleep(2000);
  
  //Go back to Organization Page or Home Page
 // hp.getOrgLink().click();
  
  
  
  //Search for organization
	//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

  //In dynamic delete OrgName

	
}

}
