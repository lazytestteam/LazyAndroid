package lazy.android.common;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangshuli@jd.com
 * @date 2016年8月2日 下午5:14:15
 * @version 1.0
 * @remark
 */
public class PhoneOperations {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected static AppiumDriver driver;

	public PhoneOperations(AppiumDriver aDriver) {
		driver = aDriver;
	}

	/**
	 * This method is used for IOS sys only!
	 * 
	 * @param driver
	 * @param iosBundleId
	 * @return
	 */
	// public static boolean isAppInstalled(AppiumDriver driver, String
	// bundleId) {
	// return driver.isAppInstalled(bundleId);
	// }

	/**
	 * install android apk
	 * 
	 * @param appPath
	 */
	public void installApp(String appPath) {
		driver.installApp(appPath);
	}

	/**
	 * close android apk
	 */
	public void closeApp() {
		driver.closeApp();
	}

	/**
	 * reset android apk
	 */
	public void resetApp() {
		driver.resetApp();
	}

	/**
	 * @param screenSavePath
	 */
	public void doScreenshot(String screenSavePath) {
		File srcScreenFile = driver.getScreenshotAs(OutputType.FILE);
		String path = screenSavePath;
		File desScreenFile = new File(path);
		try {
			FileUtils.copyFile(srcScreenFile, desScreenFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return orientation:LANDSCAPE("landscape"),PORTRAIT("portrait")
	 */
	public ScreenOrientation getOrientation() {
		return driver.getOrientation();
	}

	/**
	 * @param orientation
	 *            :LANDSCAPE("landscape"),PORTRAIT("portrait") )
	 */
	public void setOrientation(ScreenOrientation orientation) {
		driver.rotate(orientation);
	}

	/**
	 * 按下按键
	 * 
	 * @param key
	 *            ：AndroidKeyCode int BACK = 4; int BACKSPACE = 67; int DEL =
	 *            67; int ENTER = 66; int HOME = 3; int MENU = 82; int SETTINGS
	 *            = 176; int SPACE = 62;
	 */
	public void sendKeyEvent(int key) {
		driver.sendKeyEvent(key);
	}

	/**
	 * go back to front view
	 */
	public void goBack() {
		driver.sendKeyEvent(4);
	}

	/**
	 * 
	 * @param during
	 */
	public void swipeUp(int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height * 7 / 8, width / 2, height / 8, during);
	}

	/**
	 * 
	 * @param during
	 */
	public void swipeDown(int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		System.out.println(width);
		System.out.println(height);
		driver.swipe(width / 2, height / 8, width / 2, height * 7 / 8, during);
	}

	/**
	 * 
	 * @param during
	 */
	public void swipeToLeft(int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width * 7 / 8, height / 2, width / 8, height / 2, during);
	}

	/**
	 * 
	 * @param during
	 */
	public void swipeToRight(int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 8, height / 2, width * 7 / 8, height / 2, during);
	}

	/**
	 * @param el
	 */
	public void touch(WebElement el) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(el);
		driver.performTouchAction(touchAction);
	}

	/**
	 * @param x
	 * @param y
	 */
	public void touch(int x, int y) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(x, y);
		driver.performTouchAction(touchAction);
	}

	/**
	 * @param el
	 */
	public void longTouch(WebElement el) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(el);
		driver.performTouchAction(touchAction);
	}

	/**
	 * @param x
	 * @param y
	 */
	public void longTouch(int x, int y) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(x, y);
		driver.performTouchAction(touchAction);
	}

	/**
	 * 点击element控件中心点按下，duration*5毫秒秒后松开，如此重复fingers次。
	 * 
	 * @param fingers
	 * @param element
	 * @param duration
	 */
	public void tap(int fingers, WebElement element, int duration) {
		driver.tap(fingers, element, duration);
	}

	/**
	 * 点击(x,y)点按下，duration*5毫秒后松开，如此重复fingers次。
	 * 
	 * @param fingers
	 * @param x
	 * @param y
	 * @param duration
	 */
	public void tap(int fingers, int x, int y, int duration) {
		driver.tap(fingers, x, y, duration);
	}
}
