package lazy.android.controls;

import com.thoughtworks.selenium.Wait;
import io.appium.java_client.AppiumDriver;
import lazy.android.common.GlobalSettings;
import lazy.android.exceptions.ElementNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractControl {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected AppiumDriver driver;

	private String[] xpath;

	private String fullIndexXpath;

	private String validXpath;

	private String description;

	public String[] getXpath() {
		return xpath;
	}

	public void setXpath(String[] xpath) {
		this.xpath = xpath;
	}

	public String getFullIndexXpath() {
		return fullIndexXpath;
	}

	public void setFullIndexXpath(String sFullIndexXpath) {
		this.fullIndexXpath = sFullIndexXpath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取控件类型名
	 * @return
	 */
	public ControlType getType() {
		return ControlType.valueOf(this.getClass().getSimpleName()
				.toUpperCase());
	}

	public String toString() {
		return "Control{type=" + this.getClass().getSimpleName() + ", xpath=["
				+ StringUtils.join(xpath, ",") + "]" + ", fullIndexXpath=["
				+ StringUtils.join(fullIndexXpath, ",") + "]"
				+ ", description=" + description + "}";
	}

	/**
	 * 获取可以抓到该控件的xpath
	 * @return
	 */
	public String getValidXpath() {

		validXpath = getXpath()[0];
		try {
			new Wait() {
				public boolean until() {
					boolean flag = false;

					for (String xpath : getXpath()) {
						flag = driver.findElement(By.xpath(xpath))
								.isDisplayed();

						if (flag) {
							validXpath = xpath;
							break;
						}
					}

					return flag;
				}
			}.wait("Failed to find element ["
					+ StringUtils.join(getXpath(), ",") + "]",
					Long.parseLong(GlobalSettings.timeout),
					Long.parseLong(GlobalSettings.stepInterval));
		} catch (Exception e) {
			throw new ElementNotFoundException(e.getMessage());
		}

		return validXpath;
	}

	/**
	 * 获取控件显示的文字
	 * @return
	 */
	public String getText() {
		this.expectElementExistOrNot(true);
		return driver.findElement(By.xpath(getValidXpath())).getText();
	}

	/**
	 * 判断控件是否存在，不带超时重试机制
	 * @return
	 */
	public boolean isExists() {
		try {
			return driver.findElement(By.xpath(getValidXpath())).isDisplayed();
		} catch (ElementNotFoundException e) {
			return false;
		}
	}

	/**
	 * 获取控件，同toWebElement()
	 * @return
	 */
	WebElement getControl() {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		return driver.findElement(By.xpath(xpathExpression));
	}

	/**
	 * 判断元素是否存在——不带超时重试机制
	 * @param xpath
	 * @return
	 */
	public boolean isElementPresent(String xpath) {
		// pause(time);
		boolean isPresent = driver.findElement(By.xpath(xpath)).isDisplayed();
		if (isPresent) {
			logger.info("Found element " + xpath);
			return true;
		} else {
			logger.info("Not found element" + xpath);
			return false;
		}
	}

	/**
	 * 带超时重试机制的控件存在情况判断
	 * @param expectExist
	 * @param xpathArray
	 * @param timeout
	 */
	public void expectElementExistOrNot(boolean expectExist, int timeout) {
		final String xpathArray = getXpath()[0];
		if (expectExist) {
			boolean flag = false;
			long start = System.currentTimeMillis();
			long end = start + timeout;
			// try {
			while (!flag && System.currentTimeMillis() < end) {
				try {
					flag = driver.findElement(By.xpath(xpathArray))
							.isDisplayed();
				} catch (Exception e) {
				}
				if (flag)
					break;
				try {
					Thread.sleep(Long.parseLong(GlobalSettings.stepInterval));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (!flag) {
				throw new NoSuchElementException(
						"Cannot locate an element using xPath:" + xpath);
			}
		} else {
			boolean flag = false;
			long start = System.currentTimeMillis();
			long end = start + timeout;
			// try {
			while (!flag && System.currentTimeMillis() < end) {
				try {
					flag = driver.findElement(By.xpath(xpathArray))
							.isDisplayed();
				} catch (Exception e) {
				}
				if (flag) {
					throw new NoSuchElementException(
							"Cannot locate an element using xPath:" + xpath);
				}
				try {
					Thread.sleep(Long.parseLong(GlobalSettings.stepInterval));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * 带超时重试机制的控件存在情况判断
	 * @param expectExist
	 * @param xpathArray
	 * @param timeout
	 */
	public void expectElementExistOrNot(boolean expectExist) {
		expectElementExistOrNot(expectExist, Integer.parseInt(GlobalSettings.timeout));
	}
	
	/**
	 * 通过控件的xpath获取WebElement对象，同getControl()
	 * @return
	 */
	public WebElement toWebElement() {
		return driver.findElement(By.xpath(this.getValidXpath()));
	}
}
