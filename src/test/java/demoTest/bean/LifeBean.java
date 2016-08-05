package demoTest.bean;

import io.appium.java_client.AppiumDriver;
import lazy.android.annotations.Description;
import lazy.android.annotations.Xpath;
import lazy.android.bean.BaseBean;
import lazy.android.controls.View;


/** 
 * @author huangshuli@jd.com
 * @date 2016年8月1日 下午3:43:36 
 * @version 1.0 
 * @remark
 */
public class LifeBean extends BaseBean {

    @Xpath(xpath={"//android.widget.LinearLayout[@resource-id='com.wangyin.payment:id/cp_grid_view']/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]"})
    @Description(description="View 	transfer accounts")
    public View transferAccounts;
	
	public LifeBean(AppiumDriver aDriver) {
		super(aDriver);
		// TODO Auto-generated constructor stub
	}

}
