package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtilities {
	
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {

		TakesScreenshot scrShot = (TakesScreenshot) driver; // interface to capture screenshot
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);  // capture the screenshot

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// create date and time

		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot");// create folder to store screenshots
		if (!f1.exists()) {// check if folder exist

		f1.mkdirs();// if folder not found creates directory
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";// set final screenshot path
		
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);//save the screenshot to folder
		}

}
