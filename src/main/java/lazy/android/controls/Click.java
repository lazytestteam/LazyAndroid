package lazy.android.controls;

import lazy.android.interfaces.Clickable;
import org.openqa.selenium.By;

public class Click extends AbstractControl implements Clickable {

	public void click() {
		String sXpath = getValidXpath();
		driver.findElement(By.xpath(sXpath)).click();
    }
}
