package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageFooterPage {
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'])[3]") WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']") WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']") WebElement phonefield;
	@FindBy(xpath="//input[@id='email']") WebElement emailfield;
	@FindBy(xpath="//textarea[@id='content' and @name='address']") WebElement addressfield;
	@FindBy(xpath="//button[@name='Update']") WebElement updatebutton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement alertdiv;
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	public ManageFooterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMoreInfo() {
		moreinfo.click();
	}
	
	public void clickEditButton() {
		editbutton.click();
	}
	
	public void enterPhone(String phone) {
		phonefield.clear();
		phonefield.sendKeys(phone);
	}
	
	public void enterEmail(String email) {
		emailfield.clear();
		emailfield.sendKeys(email);
	}

	public void enterAddress(String address) {
		addressfield.clear();
		addressfield.sendKeys(address);
	}
	
	public void clickUpdateButton() {

		waitutility.waitForElementToBeClickable(driver, updatebutton);
		updatebutton.click();
	}
	
	public Boolean checkAlert() {
		return alertdiv.isDisplayed();
	}
	
}
