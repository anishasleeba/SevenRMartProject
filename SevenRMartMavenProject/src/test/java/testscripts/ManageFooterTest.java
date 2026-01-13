package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base{
	@Test
	public void manageContact() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();

		String phone = ExcelUtility.getStringData(1, 0, "ManageContact");
		String email = ExcelUtility.getStringData(1, 1, "ManageContact");
		String address = ExcelUtility.getStringData(1, 2, "ManageContact");
		
		ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage.clickMoreInfo();
		managefooterpage.clickEditButton();
		managefooterpage.enterPhone(phone);
		managefooterpage.enterEmail(email);
		managefooterpage.enterAddress(address);
		managefooterpage.clickUpdateButton();
		Boolean bool=managefooterpage.checkAlert();
		Assert.assertTrue(bool,"Footer not saved");
		
	}

}
