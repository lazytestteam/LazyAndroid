package lazy.android.controls;

import org.openqa.selenium.By;

import lazy.android.interfaces.Clickable;

public class Click extends AbstractControl implements Clickable {

	public void click() {
		String sXpath = getValidXpath();
		driver.findElement(By.xpath(sXpath)).click();
    }
}
