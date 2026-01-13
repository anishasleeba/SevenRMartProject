package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{

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
		String deliverytime = ExcelUtility.getStringData(1, 3, "ManageContact");
		String deliverycharge = ExcelUtility.getStringData(1, 4, "ManageContact");
		
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickMoreInfo();
		managecontactpage.clickEditButton();
		managecontactpage.enterPhone(phone);
		managecontactpage.enterEmail(email);
		managecontactpage.enterAddress(address);
		managecontactpage.enterDeliveryTime(deliverytime);
		managecontactpage.enterDeliveryCharge(deliverycharge);
		managecontactpage.clickUpdateButton();
		Boolean bool=managecontactpage.checkAlert();
		Assert.assertTrue(bool,"Contact not saved");
		
	}
}
