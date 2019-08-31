package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpageObj;
	HomePage homePage;
	AddContactsPage addContactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpageObj = new LoginPage();
		homePage = loginpageObj.loginToTechfios(prop.getProperty("userName"), prop.getProperty("userPassword"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Dashboard- TechFios Test Application - Billing");
		log.info("verifyHomePageTitleTest Successfully completed!");
	}

	@Test(priority = 2)
	public void verifyWelcomeMessageTest() {
		Assert.assertTrue(homePage.verifyWelcomeMessage());
		log.info("verifyWelcomeMessageTest Successfully validated!");
	}	

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
