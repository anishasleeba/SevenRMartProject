package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;


public class ManageContactPage {
//	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]") WebElement managecontactmoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']") WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']") WebElement phonefield;
	@FindBy(xpath="//input[@id='email']") WebElement emailfield;
	@FindBy(xpath="//textarea[@id='content' and @name='address']") WebElement addressfield;
	@FindBy(xpath="//textarea[@id='content' and @name='del_time']") WebElement deliverytimefield;
	@FindBy(xpath="//input[@id='del_limit']") WebElement deliverychargefield;
	@FindBy(xpath="//button[@name='Update']") WebElement updatebutton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement alertdiv;

	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void clickManageContactMoreInfo() {
//		managecontactmoreinfo.click();
//	}
	
	public ManageContactPage clickEditButton() {
		editbutton.click();
		return this;
	}
	
	public ManageContactPage enterPhone(String phone) {
		phonefield.clear();
		phonefield.sendKeys(phone);
		return this;
	}
	
	public ManageContactPage enterEmail(String email) {
		emailfield.clear();
		emailfield.sendKeys(email);
		return this;
	}

	public ManageContactPage enterAddress(String address) {
		addressfield.clear();
		addressfield.sendKeys(address);
		return this;
	}
	
	public ManageContactPage enterDeliveryTime(String deliverytime) {
		deliverytimefield.clear();
		deliverytimefield.sendKeys(deliverytime);
		return this;
	}
	
	public ManageContactPage enterDeliveryCharge(String deliverycharge) {
		deliverychargefield.clear();
		deliverychargefield.sendKeys(deliverycharge);
		return this;
	}
	
	public ManageContactPage clickUpdateButton() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", updatebutton);
		
		pageutility.scrollIntoView(driver, updatebutton);
		
		waitutility.waitForElementToBeClickable(driver, updatebutton);
		updatebutton.click();
		return this;
	}
	
	public Boolean checkAlert() {
		return alertdiv.isDisplayed();
	}
}
