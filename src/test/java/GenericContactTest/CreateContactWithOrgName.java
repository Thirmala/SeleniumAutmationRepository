package GenericContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ListenerUtility.BaseClass;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.CreatingNewContactPage;
import ObjectRepository.CreatingNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;

public class CreateContactWithOrgName  extends BaseClass{
	
	
	@Test
	public void contactWithOrg()  throws Exception{

		
//		String Browser=	flib.getDataFromPropertiesFile("browser");
//		String URL=	flib.getDataFromPropertiesFile("browser");
//		String UN =	flib.getDataFromPropertiesFile("browser");	
//		String PW=	flib.getDataFromPropertiesFile("browser");

		
		//generate random number
		
		int randomInt=jlib.getRandomNumber();
		
		//READ TESTSCRIPT DATA FROM EXCEL FILE
		
		String lastName =elib.getDataFromExcelContact("Sheet4",4,2);
		System.out.println(lastName);
		
		String orgName =elib.getDataFromExcelContact("Sheet4",4,3) + randomInt;
		System.out.println(orgName);
	

//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
		webdriverwait.waitForPageLoad(driver);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		

	String OrginfoHeader =driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();


     if(OrginfoHeader.contains(orgName)) {
	       System.out.println("Organization information Header is created");
      }
      
      else {
    	  SoftAssert asrt = new SoftAssert();
    	  asrt.assertTrue(false, "Organization information Header is not created");

   }
	
	
      //Navigate to contacts
     hp.getContactLink().click();
     ContactsInfoPage cif = new ContactsInfoPage(driver);
     cif.getClickConPlusBtn().click();
   
//      driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
     
     
//      driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//      driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lastName);
//      driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

     CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
     
     cncp.getlName().sendKeys(lastName);
     
     cncp.getClickOrgName().click();
     
     webdriverwait.switchToWindowOnUrl(driver,"Accounts&action");
     
     cncp.getSearchBar().sendKeys(orgName);
     
     cncp.getSearchNowBtn().click();
     
     driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
     
     webdriverwait.switchToWindowOnUrl(driver,"Contacts&action");
     
     cncp.getSaveBtn();
     

     //driver.switchTo().window(parentWindow);

     
      
      //verify header phone number info expected result
      String actLastName =driver.findElement(By.xpath("(//td[@class=\"dvtCellLabel\"])[3]")).getText();
      if(actLastName.equals(lastName)) {
    	  System.out.println(lastName+ "information is verified");
      }
      else {
    	  System.out.println(lastName+ "information is not verified");

      }
      
		
   }
	
}


