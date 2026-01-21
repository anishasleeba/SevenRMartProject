package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="//input[@name='username']") WebElement usernamefield ;
	@FindBy (xpath="//input[@name='password']") WebElement passwordfield ;
	@FindBy (xpath="//button[@type='submit']") WebElement signinbutton ;
	@FindBy (xpath="//p[text()='Dashboard']") WebElement dashboardtext;
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]") WebElement invalidcredentialdiv;
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUsername(String username) {
		usernamefield.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		passwordfield.sendKeys(password);
		return this;
	}
	
	public HomePage signinButtonClick() {
		
		signinbutton.click();
		return new HomePage(driver);	
		
	}

	public Boolean isDashboardDisplayed() {
		return dashboardtext.isDisplayed();
	}
	
	public Boolean isAlertDisplayed() {
		return invalidcredentialdiv.isDisplayed();
	}
}
