package demoTest.bean;

import io.appium.java_client.AppiumDriver;
import lazy.android.annotations.Description;
import lazy.android.annotations.Xpath;
import lazy.android.bean.BaseBean;
import lazy.android.controls.View;

/** 
 * @author huangshuli@jd.com
 * @date 2016年8月1日 下午4:50:40 
 * @version 1.0 
 * @remark
 */
public class Welcome1Bean extends BaseBean {
	
    @Xpath(xpath={"//android.widget.ImageView[@resource-id='com.wangyin.payment:id/imgview_guide']"})
    @Description(description="View hello")
    public View hello;

	public Welcome1Bean(AppiumDriver aDriver) {
		super(aDriver);
		// TODO Auto-generated constructor stub
	}

}
