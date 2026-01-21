package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewspage;
import utilities.ExcelUtility;

public class ManageNewstest extends Base{
	HomePage homepage;
	ManageNewspage managenewspage;
	
	@Test
	public void AlertPresent() throws IOException {
		
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(name).enterPassword(pass);
		//loginpage.enterPassword(pass);
		homepage=loginpage.signinButtonClick();
		
		//ManageNewspage managenewspage = new ManageNewspage(driver);
		String message = ExcelUtility.getStringData(0, 0, "ManageNews");
		//managenewspage.clickManageNewsMoreInfo();
		managenewspage=homepage.clickManageNewsMoreInfo();
		managenewspage.clickNewNews().enterMessage(message).clickSavebutton();
//		managenewspage.enterMessage(message);
//		managenewspage.clickSavebutton();
		Boolean bool = managenewspage.checkAlert();
		Assert.assertTrue(bool,Constant.ASSERTNEWS);
	}
	
	
}
