package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	@Test(retryAnalyzer = retry.Retry.class)
	public void adminUsers() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();

//		String username = ExcelUtility.getStringData(1, 0, "AdminUsers");
//		String password = ExcelUtility.getStringData(1, 1, "AdminUsers");
		FakerUtility fakerutility = new FakerUtility();
		String username = fakerutility.creatARandomFirstName()+fakerutility.creatARandomLastName();
		String password = fakerutility.creatARandomLastName();
		
		String usertype = ExcelUtility.getStringData(1, 2, "AdminUsers");
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		
		adminuserspage.clickMoreInfo();
		adminuserspage.clickNewButton();
		adminuserspage.enterUsername(username);
		adminuserspage.enterPassword(password);
		adminuserspage.enterUserType(usertype);
		adminuserspage.signinButtonClick();
		Boolean bool=adminuserspage.checkAlert();
		Assert.assertTrue(bool,Constant.ASSERTADMINUSER);
		
	}

}
