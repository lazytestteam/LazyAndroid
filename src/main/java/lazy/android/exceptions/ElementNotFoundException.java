package lazy.android.exceptions;

import io.appium.java_client.AppiumDriver;
import lazy.android.common.GlobalSettings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ElementNotFoundException extends RuntimeException {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public ElementNotFoundException(String msg) {
		super(msg);
	}
}
