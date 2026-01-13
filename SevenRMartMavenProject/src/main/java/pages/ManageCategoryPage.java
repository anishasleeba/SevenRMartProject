package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]") WebElement moreinfo;
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
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMoreInfoButton() {
		moreinfo.click();
	}
	public void clickNewButton() {
		newbutton.click();
	}

	public void enterCategory(String category) {
		categoryfield.sendKeys(category);
	}
	
	public void chooseFile() {
		
		fileuploadutility.fileUploadUsingSendkeys(imagefield, Constant.IMAGEPATH);
	}
	
	public void selectGroup() {
		groupfield.click();
	}
	
	public void clickSaveButton() {
		body.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();

		waitutility.waitForElementToBeClickable(driver, savebutton);
		savebutton.click();
	}
	
	public Boolean checkAlert() {
		return alertdiv.isDisplayed();
	}
}
