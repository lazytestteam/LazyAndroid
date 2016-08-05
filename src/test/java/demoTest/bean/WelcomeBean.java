package demoTest.bean;

import io.appium.java_client.AppiumDriver;
import lazy.android.annotations.Description;
import lazy.android.annotations.Xpath;
import lazy.android.bean.BaseBean;
import lazy.android.controls.Click;
import lazy.android.controls.View;

/** 
 * @author huangshuli@jd.com
 * @date 2016年8月1日 下午3:56:25 
 * @version 1.0 
 * @remark
 */
public class WelcomeBean extends BaseBean {

	@Xpath(xpath={"//android.widget.Button[@resource-id='com.wangyin.payment:id/btn_guide']"})
    @Description(description="Click go")
    public Click go;
	
    public WelcomeBean(AppiumDriver aDriver) {
		super(aDriver);
		// TODO Auto-generated constructor stub
	}
}
