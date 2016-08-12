package lazy.android.controls;

import lazy.android.interfaces.Checkable;
import org.openqa.selenium.By;

public class Check extends AbstractControl implements Checkable {

	/* (non-Javadoc)
	 * @see lazy.android.interfaces.Checkable#check()
	 */
	public void check() {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).click();

	}

	/* (non-Javadoc)
	 * @see lazy.android.interfaces.Checkable#unCheck()
	 */
	public void unCheck() {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		driver.findElement(By.xpath(xpathExpression)).click();
	}

	/* (non-Javadoc)
	 * @see lazy.android.interfaces.Checkable#isChecked()
	 */
	public boolean isChecked() {
		this.expectElementExistOrNot(true);
		String xpathExpression = getValidXpath();
		// return driver.findElement(By.xpath(xpathExpression)).isSelected(); //
		// appium中，使用该方法无法获取选中状态
		String b = driver.findElement(By.xpath(xpathExpression)).getAttribute(
				"checked");
		if (b.trim().equals("true"))
			return true;
		else
			return false;
	}
}
