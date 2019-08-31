package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class AddContactsPageTest extends TestBase {
	LoginPage loginpageObj;
	HomePage homePage;
	AddContactsPage addContactsPage;

	public AddContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpageObj = new LoginPage();
		addContactsPage = new AddContactsPage();
		loginpageObj.loginToTechfios(prop.getProperty("userName"), prop.getProperty("userPassword"));
		addContactsPage.clickAddContact();

	}

	@Test(priority=1)
	public void verifyAddContactaLabelTest() {
		Assert.assertTrue(addContactsPage.verifyAddContactaLabel());
		log.info("verifyAddContactaLabelTest Successfully completed!");
	}

	@Test(priority = 2, dataProvider = "getAddContactData")
	public void addContactTest(String FullName, String CompanyName, String Email, String Phone, String Address,
			String City, String StateRegion, String ZipCode) {

		addContactsPage.fillUpAddContact(FullName, CompanyName, Email, Phone, Address, City, StateRegion, ZipCode);
		
		log.info("AddContactPageTest Successfully completed!");
	}

	@DataProvider
	public Object[][] getAddContactData() {
		Object data[][] = TestUtil.getTestData("Sheet1");
		return data;
	}

	@AfterMethod
	public void tearDown() {		
		driver.close();
		driver.quit();
	}

}
