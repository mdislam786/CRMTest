package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class AddContactsPage extends TestBase {

	public AddContactsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	@FindBy(xpath = "//span[contains(text(),'CRM')]")
	WebElement CRM;

	@FindBy(xpath = "//a[contains(text(),'Add Contact')]")
	WebElement AddContact;

	@FindBy(id = "account")
	WebElement FullName;

	@FindBy(how = How.ID, using = "company")
	WebElement CompanyName;

	@FindBy(how = How.ID, using = "email")
	WebElement Email;

	@FindBy(how = How.ID, using = "phone")
	WebElement Phone;

	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement Address;

	@FindBy(how = How.ID, using = "city")
	WebElement City;

	@FindBy(how = How.ID, using = "state")
	WebElement StateRegion;

	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZipCode;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-country-container']")
	WebElement Country;

	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement Submit;

	public void clickAddContact() {
		CRM.click();
		AddContact.click();
	}

	public boolean verifyAddContactaLabel() {
		return ContactsLabel.isDisplayed();
	}

	public void fillUpAddContact(String fullName, String companyName, String email, String phone, String address,
			String city, String stateRegion, String zipCode) {

		FullName.sendKeys(fullName);
		CompanyName.sendKeys(companyName);
		Email.sendKeys(email);
		Phone.sendKeys(phone);
		Address.sendKeys(address);
		City.sendKeys(city);
		StateRegion.sendKeys(stateRegion);
		ZipCode.sendKeys(zipCode);
		Submit.click();

	}

}
