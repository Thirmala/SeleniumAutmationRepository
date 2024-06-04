package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "More")
	private WebElement morelnk;

	@FindBy(name = "Campaigns")
	private WebElement campaignslnk;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImage;

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}

	public WebElement getCampaignslnk() {
		return campaignslnk;
	}

	public WebElement getAdminImage() {
		return adminImage;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	// business utility
	public void navigateToCampainslnk() {
		Actions act = new Actions(driver);
		act.moveToElement(morelnk).perform();
		campaignslnk.click();
	}

	public void logout() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions act = new Actions(driver);
		act.moveToElement(adminImage).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signOut.click();
	}

}
