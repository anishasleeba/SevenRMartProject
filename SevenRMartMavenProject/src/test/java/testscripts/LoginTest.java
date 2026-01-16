package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();
		Boolean homepage = loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepage, Constant.ASSERTLOGINVALIDCRED);
	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword() throws IOException {

		String name = ExcelUtility.getStringData(2, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();
		Boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage, Constant.ASSERTLOGININVALIDPASS);
	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsername() throws IOException {

		String name = ExcelUtility.getStringData(3, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();
		Boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage, Constant.ASSERTLOGININVALIDUSE);
	}

	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials() throws IOException {

		String name = ExcelUtility.getStringData(4, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();
		Boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage, Constant.ASSERTLOGINVALIDCRED);
	}

}
