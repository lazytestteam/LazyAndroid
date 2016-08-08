package lazy.android.controls;

import lazy.android.interfaces.Clickable;
import org.openqa.selenium.By;

/** 
 * @author huangshuli@jd.com
 * @date 2016年7月28日 下午4:33:44 
 * @version 1.0 
 * @remark
 */
public class View extends AbstractControl implements Clickable {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		String sXpath = getValidXpath();
		driver.findElement(By.xpath(sXpath)).click();
	}
}
