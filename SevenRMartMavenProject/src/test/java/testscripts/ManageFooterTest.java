package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base{
	HomePage homepage;
	ManageFooterPage managefooterpage;
	
	@Test
	public void manageContact() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name).enterPassword(pass);
//		loginpage.enterPassword(pass);
		homepage=loginpage.signinButtonClick();

		String phone = ExcelUtility.getStringData(1, 0, "ManageContact");
		String email = ExcelUtility.getStringData(1, 1, "ManageContact");
		String address = ExcelUtility.getStringData(1, 2, "ManageContact");
		
		//ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage=homepage.clickManageFooterMoreInfo();
		managefooterpage.clickEditButton().enterPhone(phone).enterEmail(email).enterAddress(address).clickUpdateButton();
//		managefooterpage.enterPhone(phone);
//		managefooterpage.enterEmail(email);
//		managefooterpage.enterAddress(address);
		//managefooterpage.clickUpdateButton();
		Boolean bool=managefooterpage.checkAlert();
		Assert.assertTrue(bool,Constant.ASSERTFOOTER);
		
	}

}
