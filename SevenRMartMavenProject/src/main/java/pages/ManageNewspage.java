package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewspage {
	

//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement managenewsmoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement newNews;
	@FindBy(xpath="//textarea[@id='news']") WebElement enterNews;
	@FindBy(xpath="//button[@name='create']") WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement alertMessage;
	
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();

	public ManageNewspage(WebDriver driver) {	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void clickManageNewsMoreInfo() {
//		waitutility.waitForElementToBeClickable(driver, managenewsmoreInfo);
//		managenewsmoreInfo.click();
//	}
	public ManageNewspage clickNewNews() {
		newNews.click();
		return this;	
	}
	
	public ManageNewspage enterMessage(String message) {
		enterNews.sendKeys(message);
		return this;
	}
	public ManageNewspage clickSavebutton() {
		savebutton.click();
		return this;
	}
	
	public boolean checkAlert() {
		return alertMessage.isDisplayed();
	}
	
	
	
}
