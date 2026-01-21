package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
//	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]") WebElement managecategorymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']") WebElement newbutton;
	@FindBy(xpath="//input[@id='category']") WebElement categoryfield;
	@FindBy(xpath="//input[@id='main_img']") WebElement imagefield;
	@FindBy(xpath="//li[@id='134-selectable']") WebElement groupfield;
	@FindBy(xpath="//button[@name='create']") WebElement savebutton;
	@FindBy(xpath="(//input[@type='radio'])[2]") WebElement radiobutton;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]") WebElement alertdiv;
	@FindBy(tagName="body") WebElement body;
	
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	PageUtility pageutility = new PageUtility();
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void clickManageCategoryMoreInfoButton() {
//		managecategorymoreinfo.click();
//	}
	public ManageCategoryPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public ManageCategoryPage enterCategory(String category) {
		categoryfield.sendKeys(category);
		return this;
	}
	
	public ManageCategoryPage chooseFile() {
		
		fileuploadutility.fileUploadUsingSendkeys(imagefield, Constant.IMAGEPATH);
		return this;
	}
	
	public ManageCategoryPage selectGroup() {
		groupfield.click();
		return this;
	}
	
	public ManageCategoryPage clickSaveButton() {
		body.click();
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.END).perform();
		
		pageutility.sendKeysEnd(driver);

		waitutility.waitForElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}
	
	public Boolean checkAlert() {
		return alertdiv.isDisplayed();
	}
}
