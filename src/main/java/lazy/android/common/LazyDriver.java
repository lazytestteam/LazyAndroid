package lazy.android.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangshuli@jd.com
 * @date 2016年7月22日 下午7:35:35
 * @version 1.0
 * @remark
 */
public class LazyDriver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private AppiumDriver driver;

	/**
	 * app测试默认driver
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
	public LazyDriver(String AppName, String packageName, String activityName,
			String platformVersion) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		setBasicCapabilities(AppName, packageName, activityName,
				platformVersion, capabilities);

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	/**
	 * 可以选择测试开始前是否卸载app重新安装，是否清理app中的缓存数据
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
	 * @param bReset
	 * @return an AppiumDriver object
	 * @throws MalformedURLException
	 */
	public LazyDriver(String AppName, String packageName, String activityName,
			String platformVersion, Boolean bReset)
			throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		setBasicCapabilities(AppName, packageName, activityName,
				platformVersion, capabilities);

		if (bReset)
			capabilities.setCapability("fullReset", "True"); // 测试开始前，卸载app重新安装，清除app数据文件
		else
			capabilities.setCapability("noReset", "True");

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	/**
	 * 浏览器测试使用的driver
	 * 
	 * @param browseType
	 * @param platformVersion
	 * @throws MalformedURLException
	 */
	public LazyDriver(String browseType, String platformVersion)
			throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		setBasicCapabilities(browseType, platformVersion, capabilities);

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	/**
	 * basic capability setting for app-testing driver
	 * 
	 * @param AppName
	 * @param packageName
	 * @param activityName
	 * @param platformVersion
	 * @param capabilities
	 * @throws MalformedURLException
	 */
	public void setBasicCapabilities(String AppName, String packageName,
			String activityName, String platformVersion,
			DesiredCapabilities capabilities) throws MalformedURLException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, GlobalSettings.appPath);
		File app = new File(appDir, AppName);
		setPublicCapabilities(platformVersion, capabilities);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", packageName);
		capabilities.setCapability("appActivity", activityName);
	}

	/**
	 * 基本的 capability设置，用于浏览器测试。
	 * 
	 * @param browseType
	 * @param platformVersion
	 * @param capabilities
	 * @throws MalformedURLException
	 */
	public void setBasicCapabilities(String browseType, String platformVersion,
			DesiredCapabilities capabilities) throws MalformedURLException {
		setPublicCapabilities(platformVersion, capabilities);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browseType);
	}

	/**
	 * capability的基础设置，所有类型的driver公用
	 * 
	 * @param platformVersion
	 * @param capabilities
	 */
	public void setPublicCapabilities(String platformVersion,
			DesiredCapabilities capabilities) {
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
	}

	/**
	 * 获取AppiumDriver 的外部接口
	 * 
	 * @return
	 */
	public AppiumDriver getDriver() {
		return driver;
	}

	/* ###################### 手机基本操作 ####################### */

	/**
	 * 安装 android apk
	 * 
	 * @param appPath
	 */
	public void installApp(String appPath) {
		driver.installApp(appPath);
	}

	/**
	 * 关闭 android apk
	 */
	public void closeApp() {
		driver.closeApp();
	}

	/**
	 * 重置 android apk
	 */
	public void resetApp() {
		driver.resetApp();
	}

	/**
	 * 截屏
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
	 * 获取屏幕方向(水平，垂直)
	 * @return orientation:LANDSCAPE("landscape"),PORTRAIT("portrait")
	 */
	public ScreenOrientation getOrientation() {
		return driver.getOrientation();
	}

	/**
	 * 设置屏幕方向
	 * @param orientation
	 *            :LANDSCAPE("landscape"),PORTRAIT("portrait") )
	 */
	public void setOrientation(ScreenOrientation orientation) {
		driver.rotate(orientation);
	}

	/**
	 * 按键操作
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
	 * 回退到上一个页面
	 */
	public void goBack() {
		driver.sendKeyEvent(4);
	}

	/**
	 * 向上滑
	 * @param during
	 */
	public void swipeUp(int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height * 7 / 8, width / 2, height / 8, during);
	}

	/**
	 * 向上滑
	 * default during = 500
	 */
	public void swipeUp() {
		swipeUp(500);
	}

	/**
	 * 向下滑
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
	 * 向下滑
	 * default during = 500
	 */
	public void swipeDown() {
		swipeDown(500);
	}

	/**
	 * 向左滑
	 * @param during
	 */
	public void swipeToLeft(int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width * 7 / 8, height / 2, width / 8, height / 2, during);
	}

	/**
	 * 向左滑
	 * default during = 500
	 */
	public void swipeToLeft() {
		swipeToLeft(500);
	}

	/**
	 * 向右滑
	 * @param during
	 */
	public void swipeToRight(int during) {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 8, height / 2, width * 7 / 8, height / 2, during);
	}

	/**
	 * 向右滑
	 * default during = 500
	 */
	public void swipeToRight() {
		swipeToRight(500);
	}

	/**
	 * 触摸
	 * @param el
	 */
	public void touch(WebElement el) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(el);
		driver.performTouchAction(touchAction);
	}

	/**
	 * 触摸
	 * @param x
	 * @param y
	 */
	public void touch(int x, int y) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(x, y);
		driver.performTouchAction(touchAction);
	}

	/**
	 * 长按
	 * @param el
	 */
	public void longTouch(WebElement el) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(el);
		driver.performTouchAction(touchAction);
	}

	/**
	 * 长按
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

	/* ########################## Find 系列操作 ############################ */

	/**
	 * 带超时重试机制的元素查找
	 * 
	 * @param aDriver
	 * @param xpath
	 * @return
	 */
	public WebElement findElementByXpath(String xpath) {
		return findElement(xpath, Long.parseLong(GlobalSettings.timeout),
				Long.parseLong(GlobalSettings.stepInterval));
	}

	/**
	 * 带超时重试机制的元素查找
	 * 
	 * @param aDriver
	 * @param xpath
	 * @param timeout
	 * @return
	 */
	public WebElement findElementByXpath(String xpath, Long timeout) {
		return findElement(xpath, timeout,
				Long.parseLong(GlobalSettings.stepInterval));
	}

	/**
	 * 带超时重试机制的元素查找
	 * 
	 * @param aDriver
	 * @param xpath
	 * @param timeout
	 * @param stepInterval
	 * @return
	 */
	public WebElement findElementByXpath(String xpath, Long timeout,
			Long stepInterval) {
		return findElement(xpath, timeout, stepInterval);
	}

	/**
	 * 根据文字查找控件。遍历GlobalSettings.AndroidCtrType定义的安卓常用的6种控件类型，分别生成xpath进行查找，耗时较长
	 * ！
	 * 
	 * @param aDriver
	 * @param text
	 * @param timeout
	 * @return
	 */
	public WebElement findElementByText(String text) {
		List<String> xpathArray = buildXpath(text);
		WebElement wl = findElement(xpathArray);
		return wl;
	}

	/**
	 * 根据文字和控件类型查找控件。需要传入准确的安卓控件名称，耗时短，成功率高！
	 * 
	 * @param aDriver
	 * @param text
	 * @param controlTypeName
	 *            : "TextView", "Button", "CheckBox", "RadioButton",
	 *            "ImageView", "ToggleButton", ...
	 * @return
	 */
	public WebElement findElementByText(String text, String controlTypeName) {
		String xpath = buildXpath(text, controlTypeName);
		WebElement wl = findElement(xpath,
				Long.parseLong(GlobalSettings.timeout),
				Long.parseLong(GlobalSettings.stepInterval));
		return wl;
	}

	/**
	 * @param text
	 * @return
	 */
	private List<String> buildXpath(String text) {
		String xpath = "";
		List<String> xpathArray = new ArrayList<String>();
		for (String control : GlobalSettings.AndroidCtrType) {
			xpath = String.format("//android.widget.%s[@text='%s']", control,
					text);
			xpathArray.add(xpath);
		}
		return xpathArray;
	}

	/**
	 * @param text
	 * @return
	 */
	private String buildXpath(String text, String controlTypeName) {
		String xpath = String.format("//android.widget.%s[@text='%s']",
				controlTypeName, text);
		return xpath;
	}

	/**
	 * 带超时重试机制的文字捕获
	 * @param expectExist
	 * @param
	 * @param timeout
	 * @throws InterruptedException 
	 * @throws NumberFormatException 
	 */
	public void expectTextExistOrNot(boolean expectExist, String text,
			int timeout) throws NumberFormatException, InterruptedException {
		final List<String> xpathArray = buildXpath(text);
		if (expectExist) {
			boolean flag = false;
			long start = System.currentTimeMillis();
			long end = start + timeout;
			while (!flag && System.currentTimeMillis() < end) {
				for (String xpath : xpathArray) {
					try{
						flag = driver.findElement(By.xpath(xpath)).isDisplayed();
					} catch (Exception e) {
					}
					if (flag)
						break;
				}
				Thread.sleep(Long.parseLong(GlobalSettings.stepInterval));
			}
			if (!flag) {
				throw new NoSuchElementException(
						"Cannot locate an element using xPath:"
								+ xpathArray.toString());
			}
		} else {
			boolean flag = false;
			long start = System.currentTimeMillis();
			long end = start + timeout;
			while (!flag && System.currentTimeMillis() < end) {
				for (String xpath : xpathArray) {
					try{
						flag = driver.findElement(By.xpath(xpath))
								.isDisplayed();
					} catch(Exception e) {
					}
					if (flag) {
						throw new NoSuchElementException(
								"Has located an element using xPath:" + xpathArray.toString());
					}
				}
					Thread.sleep(Long.parseLong(GlobalSettings.stepInterval));
	
			}
		}
	}
	
	/**
	 * 带超时重试机制的文字捕获
	 * @param expectExist
	 * @param text
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */
	public void expectTextExistOrNot(boolean expectExist, String text) throws NumberFormatException, InterruptedException {
		expectTextExistOrNot(expectExist, text, Integer.parseInt(GlobalSettings.timeout));
	}
	
	/**
	 * 带超时重试机制的控件查找——通过xpath
	 * @param aDriver
	 * @param xpath
	 * @param timeout
	 * @param stepInterval
	 * @return
	 */
	private WebElement findElement(String xpath, Long timeout, Long stepInterval) {
		final String xpathArray = xpath;
		boolean flag = false;
		long start = System.currentTimeMillis();
		long end = start + timeout;
		try {
			while (!flag && System.currentTimeMillis() < end) {
				try {
					flag = driver.findElement(By.xpath(xpathArray))
							.isDisplayed();
				} catch (Exception e) {
				}
				if (flag)
					break;
				Thread.sleep(stepInterval);
			}

			if (!flag) {
				throw new NoSuchElementException(
						"Cannot locate an element using xPath:" + xpath);
			} else {
				return driver.findElement(By.xpath(xpathArray));
			}
		} catch (Exception e) {
			throw new NoSuchElementException(
					"Cannot locate an element using xPath:" + xpath);
		}
	}

	/**
	 *带超时重试机制的控件查找——通过xpath list
	 * 
	 * @param aDriver
	 * @param xpathArray2
	 *            ：xpath arrayList
	 * @return
	 */
	private WebElement findElement(List<String> xpathArray2) {
		final List<String> xpathArray = xpathArray2;
		boolean flag = false;
		String xpath = "";
		int i = 0;
		while (!flag && i < xpathArray.size()) {
			try {
				flag = driver.findElement(By.xpath(xpathArray.get(i)))
						.isDisplayed();
			} catch (Exception e) {
			}
			if (flag) {
				xpath = xpathArray.get(i);
				break;
			}
			++i;
		}

		if (!flag) {
			throw new NoSuchElementException(
					"Cannot locate an element using xPaths:"
							+ xpathArray.toString());
		} else {
			return driver.findElement(By.xpath(xpath));
		}
	}
}
