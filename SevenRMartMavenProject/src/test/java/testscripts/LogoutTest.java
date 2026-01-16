package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{

	@Test
	public void logout() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();

		LogoutPage logout = new LogoutPage(driver);
		logout.usernameClick();
		logout.logoutButtonClick();
		Boolean bool = logout.signinTextCheck();
		Assert.assertTrue(bool, Constant.ASSERTLOGOUT);
	}
	
}
