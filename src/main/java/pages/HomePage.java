package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='hidden-xs']")
	WebElement welcomeTester;

	@FindBy(xpath = "//span[contains(text(),'CRM')]")
	WebElement CRM;

	@FindBy(xpath = "//a[contains(text(),'Add Contact')]")
	WebElement AddContact;

	@FindBy(xpath = "//span[contains(text(),'Transactions')]")
	WebElement Transactions;

	@FindBy(xpath = "//a[contains(text(),'New Expense')]")
	WebElement NewExpense;

	@FindBy(xpath = "//span[@class='hidden-xs']")
	WebElement WelcomeTester;

	public boolean verifyWelcomeMessage() {
		return WelcomeTester.isDisplayed();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public AddContactsPage clickAddContact() {
		CRM.click();
		AddContact.click();
		return new AddContactsPage();
	}

}
