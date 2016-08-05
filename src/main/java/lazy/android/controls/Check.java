package lazy.android.controls;
import org.openqa.selenium.By;

import lazy.android.interfaces.Checkable;

public class Check extends AbstractControl implements Checkable {

    public void check() {
    	String xpathExpression = getValidXpath();  	
    	driver.findElement(By.xpath(xpathExpression)).click();
    	
    }

    public void unCheck() {
    	String xpathExpression = getValidXpath();
    	driver.findElement(By.xpath(xpathExpression)).click();
    }

    public boolean isChecked() {
    	String xpathExpression = getValidXpath();

    	// return driver.findElement(By.xpath(xpathExpression)).isSelected();      	// appium中，使用该方法无法获取选中状态
    	String b = driver.findElement(By.xpath(xpathExpression)).getAttribute("checked");
    	if (b.trim().equals("true"))
    		return true;
    	else 
    		return false;
    }
}
