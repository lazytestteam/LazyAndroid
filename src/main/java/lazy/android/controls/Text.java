package lazy.android.controls;

import lazy.android.interfaces.Clearable;
import lazy.android.interfaces.Inputable;
import org.openqa.selenium.By;

/**
 * @author huangshuli@jd.com
 * @date 2016年7月28日 下午6:33:16
 * @version 1.0
 * @remark
 */
public class Text extends AbstractControl implements Inputable, Clearable {

	/* (non-Javadoc)
	 * @see lazy.android.interfaces.Inputable#input(java.lang.String)
	 */
	public void input(String value) {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
	}

	/* (non-Javadoc)
	 * @see lazy.android.interfaces.Clearable#clear()
	 */
	public void clear() {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).clear();
	}

	/* (non-Javadoc)
	 * @see lazy.android.controls.AbstractControl#getText()
	 */
	public String getText() {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		String str = driver.findElement(By.xpath(xpathExpression)).getText();
		return str;
	}

	/**
	 * 单击
	 */
	public void click() {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).click();
	}
}
