package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtilities;

public class Base {

	public WebDriver driver;
	FileInputStream fileinputstream;
	Properties properties;
	ScreenshotUtilities screenshotutilities;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")

	public void initialiseBrowser(String browser) throws Exception {

		try {
			fileinputstream = new FileInputStream(Constant.CONFIGPATH);
			properties = new Properties();
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println(e);
		}

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else {
			throw new Exception("Invalid browser");
		}

		//driver = new ChromeDriver();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void close( ITestResult iTestResult) throws IOException {
		
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenshotutilities = new ScreenshotUtilities();
			screenshotutilities.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit(); // --> close all tabs
	}
}
