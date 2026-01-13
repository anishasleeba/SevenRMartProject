package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{
	@Test
	public void manageCategory() throws IOException {
		String name = ExcelUtility.getStringData(1, 0, "LoginPage");
		String pass = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername(name);
		loginpage.enterPassword(pass);
		loginpage.signinButtonClick();
		
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		String category = ExcelUtility.getStringData(1, 0, "Category");
		
		managecategorypage.clickMoreInfoButton();
		managecategorypage.clickNewButton();
		managecategorypage.enterCategory(category);
		managecategorypage.chooseFile();
		managecategorypage.selectGroup();
		managecategorypage.clickSaveButton();
		Boolean bool=managecategorypage.checkAlert();
		Assert.assertTrue(bool,"Category not saved");
		
	}
}
