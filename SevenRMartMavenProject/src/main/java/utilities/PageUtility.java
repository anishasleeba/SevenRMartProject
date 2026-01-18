package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void scrollIntoView(WebDriver driver,WebElement element ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);		
	}
	
	public void sendKeysEnd(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.END).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions actions =new Actions(driver);
		actions.moveToElement(element).perform();
	}	

}
