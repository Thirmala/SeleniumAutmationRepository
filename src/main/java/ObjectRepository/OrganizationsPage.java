package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@name=\"search_text\"]")
	private WebElement searchText;
	
	@FindBy(xpath="//select[@name=\"search_field\"]")
	private WebElement orgNo;
	
	

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getOrgNo() {
		return orgNo;
	}
	
	
	
	
}
