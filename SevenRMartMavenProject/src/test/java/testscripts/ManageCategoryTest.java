package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageCategoryTest extends Base{
	HomePage homepage;
	ManageCategoryPage managecategorypage;
	
	@Test
	public void manageCategory() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name).enterPassword(pass);
		//loginpage.enterPassword(pass);
		homepage=loginpage.signinButtonClick();
		
		//ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		String category1 = ExcelUtility.getStringData(1, 0, "Category");
		
		FakerUtility fakerutility = new FakerUtility();
		String category = fakerutility.creatARandomFirstName()+category1;
		//managecategorypage.clickManageCategoryMoreInfoButton();
		managecategorypage=homepage.clickManageCategoryMoreInfoButton();
		managecategorypage.clickNewButton().enterCategory(category).chooseFile().selectGroup().clickSaveButton();
//		managecategorypage.enterCategory(category);
//		managecategorypage.chooseFile();
//		managecategorypage.selectGroup();
//		managecategorypage.clickSaveButton();
		Boolean bool=managecategorypage.checkAlert();
		Assert.assertTrue(bool,Constant.ASSERTMANAGECATEGORY);
		
	}
}
