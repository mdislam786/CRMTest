package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpageObj;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("BeforeMethod");
		initialization();
		loginpageObj = new LoginPage();
	}

	@Test(priority=1)
	public void loginTest() {
		log.info("loginTest");
		homePage = loginpageObj.loginToTechfios(prop.getProperty("userName"), prop.getProperty("userPassword"));
	}

	@Test(priority=2)
	public void loginpageTitleTest() {
		log.info("loginpageTitleTest");
		String title = loginpageObj.validatePageTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
	}

	@AfterMethod
	public void tearDown() {
		log.info("AfterMethod");
		driver.close();
		driver.quit();
	}

}
