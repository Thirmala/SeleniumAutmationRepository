package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericWebDriverUtility.WebDriverUtility;
import ListenerUtility.BaseClass;



public class LoginPage{
	
	
	
	//lazy initialization
	//constructor
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name="user_name")
    private	WebElement username;
	
	@FindBy(name="user_password")
	private	WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	

//no need of getters we can perform action of WE in business library

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//business library
	public void Applogin(String url , String UN, String PW) {
 
		
		driver.get(url);
		username.sendKeys(UN);
		password.sendKeys(PW);
		loginBtn.click();
	}
	

}
