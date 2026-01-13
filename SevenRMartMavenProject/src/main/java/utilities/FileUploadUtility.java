package utilities;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendkeys(WebElement choosefile,String path) {
		choosefile.sendKeys(path);
	}

}
