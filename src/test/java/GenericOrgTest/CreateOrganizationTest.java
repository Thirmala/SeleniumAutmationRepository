package GenericOrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import GenericFileUtility.ExcelUtility;
import GenericFileUtility.FileUtility;
import GenericWebDriverUtility.JavaUtility;
import GenericWebDriverUtility.WebDriverUtility;
import ListenerUtility.BaseClass;
import ObjectRepository.CreatingNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void OrgTest() throws Exception {
		// TODO Auto-generated method stub

		webdriverwait.waitForPageLoad(driver);

		// READ TESTSCRIPT DATA FROM EXCEL FILE from a Cell and Provide randomNumber
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);

		hp.getOrgLink().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		oip.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName);

	}

	@Test
	public void OrgTest2() throws Exception {

		webdriverwait.waitForPageLoad(driver);

		// READ TESTSCRIPT DATA FROM EXCEL FILE from a Cell and Provide randomNumber
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 1, 4) + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);

		hp.getOrgLink().click();

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		oip.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName, industry);

	}
}
