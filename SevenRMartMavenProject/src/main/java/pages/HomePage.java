package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage{
	
	@FindBy(xpath="(//a[@href='#'])[2]") WebElement username;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]") WebElement logoutbutton;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement signintext;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]") WebElement adminmoreinfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]") WebElement managecategorymoreinfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]") WebElement managecontactmoreinfo;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[3]") WebElement managefootermoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement managenewsmoreInfo;
	
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AdminUsersPage clickAdminMoreInfo() {
		adminmoreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageCategoryPage clickManageCategoryMoreInfoButton() {
		managecategorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	
	public ManageContactPage clickManageContactMoreInfo() {
		managecontactmoreinfo.click();
		return new ManageContactPage(driver);
	}
	
	public ManageFooterPage clickManageFooterMoreInfo() {
		managefootermoreinfo.click();
		return new ManageFooterPage(driver);
	}
	
	public ManageNewspage clickManageNewsMoreInfo() {
		waitutility.waitForElementToBeClickable(driver, managenewsmoreInfo);
		managenewsmoreInfo.click();
		return new ManageNewspage(driver);
	}
	
	public void usernameClick() {
		username.click();
	}
	
	public void logoutButtonClick() {
		waitutility.waitForElementToBeClickable(driver, logoutbutton);
		logoutbutton.click();
	}
	public Boolean signinTextCheck() {
		return signintext.isDisplayed();
	}
}
