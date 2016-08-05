package lazy.android.exceptions;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import lazy.android.common.GlobalSettings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ElementNotFoundException extends RuntimeException {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public ElementNotFoundException(String msg) {
		super(msg);
	}

	private void handleFailure(AppiumDriver driver, String notice) {

		if (GlobalSettings.baseStorageUrl.lastIndexOf("/") == GlobalSettings.baseStorageUrl
				.length()) {
			GlobalSettings.baseStorageUrl = GlobalSettings.baseStorageUrl
					.substring(0, GlobalSettings.baseStorageUrl.length() - 1);
		}

		File srcScreenFile = driver.getScreenshotAs(OutputType.FILE);
		String path = GlobalSettings.baseStorageUrl;
		File desScreenFile = new File(path);
		try {
			FileUtils.copyFile(srcScreenFile, desScreenFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String log = notice + " >> capture screenshot!";
		logger.error(log);
		if (GlobalSettings.baseStorageUrl.lastIndexOf("/") == GlobalSettings.baseStorageUrl
				.length()) {
			GlobalSettings.baseStorageUrl = GlobalSettings.baseStorageUrl
					.substring(0, GlobalSettings.baseStorageUrl.length() - 1);
		}
		Assert.fail(log);
	}
}
