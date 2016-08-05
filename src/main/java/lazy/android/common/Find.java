package lazy.android.common;

import io.appium.java_client.AppiumDriver;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.thoughtworks.selenium.Wait;

/**
 * @author huangshuli@jd.com
 * @date 2016年8月3日 下午4:08:46
 * @version 1.0
 * @remark
 */
public class Find {

	/**
	 * 带超时重试机制的元素查找
	 * 
	 * @param aDriver
	 * @param xpath
	 * @return
	 */
	public static WebElement findElementByXpath(AppiumDriver aDriver,
			String xpath) {
		final String xpathArray = xpath;
		final AppiumDriver driver = aDriver;
		boolean flag = false;
		long start = System.currentTimeMillis();
		long end = start + Long.parseLong(GlobalSettings.timeout);
		try {
			while (!flag && System.currentTimeMillis() < end) {
				try {
					flag = driver.findElement(By.xpath(xpathArray))
							.isDisplayed();
				} catch (Exception e) {
				}
				if (flag)
					break;
				Thread.sleep(Long.parseLong(GlobalSettings.stepInterval));
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
	 * 带超时重试机制的元素查找
	 * 
	 * @param aDriver
	 * @param xpath
	 * @param timeout
	 * @return
	 */
	public static WebElement findElementByXpath(AppiumDriver aDriver,
			String xpath, Long timeout) {
		final String xpathArray = xpath;
		final AppiumDriver driver = aDriver;
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
				Thread.sleep(Long.parseLong(GlobalSettings.stepInterval));
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
	 * 带超时重试机制的元素查找
	 * 
	 * @param aDriver
	 * @param xpath
	 * @param timeout
	 * @param stepInterval
	 * @return
	 */
	public static WebElement findElementByXpath(AppiumDriver aDriver,
			String xpath, Long timeout, Long stepInterval) {
		final String xpathArray = xpath;
		final AppiumDriver driver = aDriver;
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
}
