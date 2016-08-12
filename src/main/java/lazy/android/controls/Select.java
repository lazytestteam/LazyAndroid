package lazy.android.controls;

import lazy.android.interfaces.Selectable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangshuli@jd.com
 * @date 2016年7月26日 下午1:57:22
 * @version 1.0
 * @remark
 */
public class Select extends AbstractControl implements Selectable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lazy.test.android.interfaces.Selectable#selectByVisibleText(java.lang
	 * .String)
	 */
	@Override
	public void selectByVisibleText(String option) {
		// TODO Auto-generated method stub

		this.expectElementExistOrNot(true);
		getControl().click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement webElement = driver.findElement(By.name(option));
		webElement.click();
		System.out.print(webElement.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lazy.test.android.interfaces.Selectable#selectByIndex(int)
	 */
	@Override
	public void selectByIndex(int index) {
		// TODO Auto-generated method stub
		this.expectElementExistOrNot(true);
		getControl().click();

		try {
			driver.wait(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> webList = driver
				.findElementsByClassName("android.widget.CheckedTextView");

		try {
			driver.wait(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webList.get(index).click();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lazy.test.android.interfaces.Selectable#selectByValue(java.lang.String)
	 */
	@Override
	public void selectByValue(String value) {
		// TODO Auto-generated method stub

		this.expectElementExistOrNot(true);
		getControl().click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement webElement = driver.findElement(By.name(value));
		System.out.print(webElement.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lazy.test.android.interfaces.Selectable#getAllOptions()
	 */
	@Override
	public List<String> getAllOptions() {
		// TODO Auto-generated method stub
		this.expectElementExistOrNot(true);
		getControl().click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> res = new ArrayList<String>();
		List<WebElement> webList = driver
				.findElementsByClassName("android.widget.CheckedTextView");

		for (WebElement wl : webList) {
			res.add(wl.getText());
		}

		return res;
	}

	// ######################## 通过子控件TextView.getText()去获取
	/*
	 * (non-Javadoc)
	 * 
	 * @see lazy.test.android.interfaces.Selectable#getSelectedOptions()
	 */
	@Override
	public String getSelectedOptions() {
		// TODO Auto-generated method stub
		this.expectElementExistOrNot(true);
		String Xpath = this.getValidXpath();
		Xpath += "/android.widget.TextView[1]";
		WebElement tx = driver.findElement(By.xpath(Xpath));
		String selText = tx.getText();
		return selText;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.expectElementExistOrNot(true);
		getControl().clear();
	}

}
