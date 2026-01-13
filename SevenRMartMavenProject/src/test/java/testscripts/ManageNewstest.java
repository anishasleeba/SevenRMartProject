package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewspage;
import utilities.ExcelUtility;

public class ManageNewstest extends Base{

	@Test
	public void AlertPresent() throws IOException {
		
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();
		
		ManageNewspage managenewspage = new ManageNewspage(driver);
		String message = ExcelUtility.getStringData(0, 0, "ManageNews");
		managenewspage.clickMoreInfo();
		managenewspage.clickNewNews();
		managenewspage.enterMessage(message);
		managenewspage.clickSavebutton();
		Boolean bool = managenewspage.checkAlert();
		Assert.assertTrue(bool,"by giving new mews ,alert not present");
	}
	
	
}
