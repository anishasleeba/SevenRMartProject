package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	HomePage homepage;
	ManageContactPage managecontactpage;

	@Test
	public void manageContact() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name).enterPassword(pass);
		//loginpage.enterPassword(pass);
		homepage=loginpage.signinButtonClick();

		String phone = ExcelUtility.getStringData(1, 0, "ManageContact");
		String email = ExcelUtility.getStringData(1, 1, "ManageContact");
		String address = ExcelUtility.getStringData(1, 2, "ManageContact");
		String deliverytime = ExcelUtility.getStringData(1, 3, "ManageContact");
		String deliverycharge = ExcelUtility.getStringData(1, 4, "ManageContact");
		
//		ManageContactPage managecontactpage = new ManageContactPage(driver);
//		managecontactpage.clickManageContactMoreInfo();
		managecontactpage=homepage.clickManageContactMoreInfo();
		managecontactpage.clickEditButton().enterPhone(phone).enterEmail(email).enterAddress(address).enterDeliveryTime(deliverytime).enterDeliveryCharge(deliverycharge).clickUpdateButton();
//		managecontactpage.enterPhone(phone);
//		managecontactpage.enterEmail(email);
//		managecontactpage.enterAddress(address);
//		managecontactpage.enterDeliveryTime(deliverytime);
//		managecontactpage.enterDeliveryCharge(deliverycharge);
//		managecontactpage.clickUpdateButton();
		Boolean bool=managecontactpage.checkAlert();
		Assert.assertTrue(bool,Constant.ASSERTMANAGECONTACT);
		
	}
}
