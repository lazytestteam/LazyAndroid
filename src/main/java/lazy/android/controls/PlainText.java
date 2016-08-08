package lazy.android.controls;
import org.openqa.selenium.By;

/** 
 * @author huangshuli@jd.com
 * @date 2016年7月26日 下午1:57:51 
 * @version 1.0 
 * @remark
 */

public class PlainText extends AbstractControl{

    public String getText(){
    	String xpathExpression = getValidXpath();  	
    	String str = driver.findElement(By.xpath(xpathExpression)).getText();
    	return str;
    }
    
}
