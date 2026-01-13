package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{
	@Test
	public void adminUsers() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();

		String username = ExcelUtility.getStringData(1, 0, "AdminUsers");
		String password = ExcelUtility.getStringData(1, 1, "AdminUsers");
		String usertype = ExcelUtility.getStringData(1, 2, "AdminUsers");
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		
		adminuserspage.clickMoreInfo();
		adminuserspage.clickNewButton();
		adminuserspage.enterUsername(username);
		adminuserspage.enterPassword(password);
		adminuserspage.enterUserType(usertype);
		adminuserspage.signinButtonClick();
		Boolean bool=adminuserspage.checkAlert();
		Assert.assertTrue(bool,"User not saved");
		
	}

}
