package lazy.android.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author huangshuli@jd.com
 * @date 2016年7月22日 下午7:35:35
 * @version 1.0
 * @remark
 */
public class LazyDriver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 默认driver
	 * 
	 * @param AppName
	 *            (for exapmle: "SimpleApp.apk")
	 * @param packageName
	 *            (for exapmle: "simple.app")
	 * @param activityName
	 *            (activityName must begin with ".", for exapmle:
	 *            ".SimpleAppActivity")
	 * @param platformVersion
	 *            (for exapmle: "4.2.2")
	 * @return an AppiumDriver object
	 * @throws MalformedURLException
	 */
	public static AppiumDriver getSimpleAppDriver(String AppName,
			String packageName, String activityName, String platformVersion)
			throws MalformedURLException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, GlobalSettings.appPath);
		File app = new File(appDir, AppName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", packageName);
		capabilities.setCapability("appActivity", activityName);
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		capabilities.setCapability("noReset", "True");

		return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	/**
	 * 测试开始前，不卸载app重新安装
	 * 
	 * @param AppName
	 *            (for exapmle: "SimpleApp.apk")
	 * @param packageName
	 *            (for exapmle: "simple.app")
	 * @param activityName
	 *            (activityName must begin with ".", for exapmle:
	 *            ".SimpleAppActivity")
	 * @param platformVersion
	 *            (for exapmle: "4.2.2")
	 * @return an AppiumDriver object
	 * @throws MalformedURLException
	 */
	public static AppiumDriver getNoResetAppDriver(String AppName,
			String packageName, String activityName, String platformVersion)
			throws MalformedURLException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, GlobalSettings.appPath);
		File app = new File(appDir, AppName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", packageName);
		capabilities.setCapability("appActivity", activityName);
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		capabilities.setCapability("noReset", "True");

		return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	/**
	 * 测试开始前，卸载app重新安装，清除app数据文件
	 * 
	 * @param AppName
	 *            (for exapmle: "SimpleApp.apk")
	 * @param packageName
	 *            (for exapmle: "simple.app")
	 * @param activityName
	 *            (activityName must begin with ".", for exapmle:
	 *            ".SimpleAppActivity")
	 * @param platformVersion
	 *            (for exapmle: "4.2.2")
	 * @return an AppiumDriver object
	 * @throws MalformedURLException
	 */
	public static AppiumDriver getFullResetAppDriver(String AppName,
			String packageName, String activityName, String platformVersion)
			throws MalformedURLException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, GlobalSettings.appPath);
		File app = new File(appDir, AppName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", packageName);
		capabilities.setCapability("appActivity", activityName);
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		capabilities.setCapability("fullReset", "True");

		return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	/**
	 * 浏览器测试使用
	 * 
	 * @param browseType
	 *            (for exapmle: BrowserType.CHROME)
	 * @param platformVersion
	 *            (for exapmle: "4.2.2")
	 * @return an AppiumDriver object
	 * @throws MalformedURLException
	 */
	public static AppiumDriver getSimpleWebDriver(String browseType,
			String platformVersion) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browseType);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");

		return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

}
