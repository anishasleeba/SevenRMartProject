package testscripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constant.Constant;

public class Base {

	public WebDriver driver;
	FileInputStream fileinputstream;
	Properties properties;

	@BeforeMethod

	public void initialiseBrowser() {

		try {
			fileinputstream = new FileInputStream(Constant.CONFIGPATH);
			properties = new Properties();
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println(e);
		}

		driver = new ChromeDriver();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close(); // close current tab
		// driver.quit(); // --> close all tabs
	}
}
