package GenericUtilityContact;

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

public class CreateContactWithOrgName {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
		
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\thiru\\OneDrive\\Desktop\\ExcelSheetPoi\\ContactWithOrgName.xlsx");
		
		Workbook wb =WorkbookFactory.create(fis1);
		
		   Sheet sh = wb.getSheet("Sheet4");
		   
	    Row row=  sh.getRow(4);
		    //row 5 means index 4
		    
        //get the control of 2nd Cell & read String Data
	       Cell cell =row.getCell(2);
	       String lastName=cell.toString();
	       //** add random int variable to get random number for orgname
		   String orgName =cell.toString()+ randomInt ;  
		   
//		   cell.setCellType(CellType.STRING);
//		   cell.setCellValue(orgName);
		    
//		System.out.println(orgName);
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
         driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();


	String OrginfoHeader =driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();

      if(OrginfoHeader.contains(orgName)) {
	       System.out.println("Organization information Header is created");
       }
      
      else {
	       System.out.println("Organization information Header is not created");

      }
      Thread.sleep(2000);
      
      //Navigate to contacts
      driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
      driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
      driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lastName);
      driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
      
      
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
