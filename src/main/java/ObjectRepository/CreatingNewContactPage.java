package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericWebDriverUtility.WebDriverUtility;

public class CreatingNewContactPage {
WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name=\"lastname\"]")
	private WebElement lName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement clickOrgName;
	
	
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement searchBar;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchNowBtn;
	
	
	

	public WebElement getlName() {
		return lName;
	}
	
	
	
	public WebElement getClickOrgName() {
		return clickOrgName;
	}


	public void createContWithLastName(String s) {
		
		lName.sendKeys(s);
		
		saveBtn.click();
				
	}


	public WebDriverUtility getWlib() {
		return wlib;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


     public WebElement getSearchBar() {
		return searchBar;
	}


	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	
//public void createContcWithLastNameAndOrg(String partUrl, String orgname) {
//		
//		wlib.switchToWindowOnUrl(driver, partUrl);
//		searchBar.sendKeys(orgname);
//		searchNowBtn.click();
//		//driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
//		
//		
//				
//	}
}
