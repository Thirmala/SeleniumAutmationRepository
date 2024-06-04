package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
WebDriver driver = null;
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"accountname\"]")
	private WebElement orgName;
	
	@FindBy(name="industry")
	private WebElement industrySel;
	
	
	@FindBy(xpath ="//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	
	public void createOrg(String s ) {
		orgName.sendKeys(s);
		
		saveButton.click();
	}
	
	public void createOrg(String s , String Industry) {
		
		orgName.sendKeys(s);
		Select selObj = new Select(industrySel);
		
		selObj.selectByVisibleText(Industry);
		
		saveButton.click();
	}
	
	
	
	
}
