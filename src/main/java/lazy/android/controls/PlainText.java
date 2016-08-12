package lazy.android.controls;

import org.openqa.selenium.By;

/**
 * @author huangshuli@jd.com
 * @date 2016年7月26日 下午1:57:51
 * @version 1.0
 * @remark
 */

public class PlainText extends AbstractControl {

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
