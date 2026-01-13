package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LogoutPage{
	
	@FindBy(xpath="(//a[@href='#'])[2]") WebElement username;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]") WebElement logoutbutton;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement signintext;
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
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
