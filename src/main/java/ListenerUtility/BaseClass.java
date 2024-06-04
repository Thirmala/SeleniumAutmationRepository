package ListenerUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import GenericDataBaseUtility.DataBaseUtility;
import GenericFileUtility.ExcelUtility;
import GenericFileUtility.FileUtility;
import GenericWebDriverUtility.JavaUtility;
import GenericWebDriverUtility.WebDriverUtility;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public static WebDriver sdriver;
	public WebDriver driver;

	public WebDriverUtility webdriverwait = new WebDriverUtility();

	public FileUtility flib = new FileUtility();

	public JavaUtility jlib = new JavaUtility();

	public ExcelUtility elib = new ExcelUtility();

	public DataBaseUtility dlib = new DataBaseUtility();

	@BeforeSuite
	public void dbConnection() throws Exception {

		System.out.println("Connect to Data Base");
		dlib.getDbConnection();

	}

	@BeforeClass
	public void getCommonData() throws Exception {

		System.out.println("Launch the browser");

		// read Common Data from Property file
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();

		sdriver= driver;
		
	}

	@BeforeMethod
	public void login() throws Exception {
		System.out.println("==login==");
		String URL = flib.getDataFromPropertiesFile("url");

		String UN = flib.getDataFromPropertiesFile("username");
		String PW = flib.getDataFromPropertiesFile("password");

		LoginPage lp= new LoginPage(driver);
		lp.Applogin(URL, UN, PW);

	}

	@AfterMethod
	public void logout() {
		System.out.println("==logout==");
		HomePage hp = new HomePage(driver);
		hp.logout();

	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("==close the browser==");
		driver.quit();

	}

	@AfterSuite
	public void closeDBconnection() throws Exception {
		System.out.println("==close the DB connection==");
		dlib.closeDbconnection();

	}

}
