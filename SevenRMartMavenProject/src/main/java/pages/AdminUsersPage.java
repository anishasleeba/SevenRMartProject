package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]") WebElement adminmoreinfo;
	@FindBy(xpath="//section[@class='content']/div[1]/a[1]") WebElement newbutton;
	@FindBy(xpath="//input[@id='username']") WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']") WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']") WebElement usertypedropdown;
	@FindBy(xpath="//button[@name='Create']") WebElement savebutton;
	//@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement alertdiv;
	@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertmsg;
	
	public WebDriver driver;
	
	PageUtility pageutility = new PageUtility();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//	public void clickAdminMoreInfo() {
//		adminmoreinfo.click();
//	}
	public AdminUsersPage clickNewButton() {
		newbutton.click();
		return this;
	}
	
	public AdminUsersPage enterUsername(String username) {
		usernamefield.clear();
		usernamefield.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterPassword(String password) {
		passwordfield.clear();
		passwordfield.sendKeys(password);
		return this;
	}
	
	public AdminUsersPage enterUserType(String usertype) {
		pageutility.selectByVisibleText(usertypedropdown, usertype);
		return this;
		
	}
	public AdminUsersPage signinButtonClick() {
		
		savebutton.click();
		return this;	
		
	}
	
	public Boolean checkAlert() {
		//return alertdiv.isDisplayed();
		return alertmsg.isDisplayed();
	}
	
}
