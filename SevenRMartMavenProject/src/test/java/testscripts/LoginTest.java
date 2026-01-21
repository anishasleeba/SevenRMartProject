package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(groups = { "regression" })
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

	@Test(groups = { "regression" })
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

	@Test(groups = { "regression" })
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

	@Test(dataProvider="loginProvider",groups = { "regression" })
	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials(String name,String pass) throws IOException {

		//String name = ExcelUtility.getStringData(4, 0, "LoginPage");
		//String pass = ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();
		Boolean homepage = loginpage.isAlertDisplayed();
		Assert.assertTrue(homepage, Constant.ASSERTLOGINVALIDCRED);
	}
	
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },};}

}
