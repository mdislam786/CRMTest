package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
		//this.driver = driver;
	}
	
	//Object Repository
	
	@FindBy(css = "#username")
	// @CacheLookup
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement userPassword;

	@FindBy(xpath = "//button[@name='login']")
	WebElement loginButton;
	
	public HomePage loginToTechfios(String username,String password) {
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();
		
		return new HomePage();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}

}
