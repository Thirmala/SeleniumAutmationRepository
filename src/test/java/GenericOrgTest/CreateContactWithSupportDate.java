package GenericOrgTest;

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

public class CreateContactWithSupportDate {

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
		
		Date date = new Date();
		System.out.println(	date.toString());	

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		 String todayDate  =sim.format(date);
		 
		 Calendar cal =sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH, 30);
		 String DateAfter30Days = sim.format(cal.getTime());
		 System.out.println(DateAfter30Days);

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PW);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();


		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		driver.findElement(By.xpath("//input[@name=\"support_start_date\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"support_start_date\"]")).sendKeys(todayDate);
		driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).sendKeys(DateAfter30Days);
		Thread.sleep(2000);
		

	driver.quit();			

	}

}
