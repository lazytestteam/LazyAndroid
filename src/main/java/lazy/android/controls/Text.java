package lazy.android.controls;

import org.openqa.selenium.By;

import lazy.android.interfaces.Clearable;
import lazy.android.interfaces.Inputable;

/**
 * @author huangshuli@jd.com
 * @date 2016年7月28日 下午6:33:16
 * @version 1.0
 * @remark
 */
public class Text extends AbstractControl implements Inputable, Clearable {

	public void input(String value) {
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
	}

	public void clear() {
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).clear();
	}

	public String getText() {
		String xpathExpression = getValidXpath();
		String str = driver.findElement(By.xpath(xpathExpression)).getText();
		return str;
	}

	public void click() {
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).click();
	}
}
