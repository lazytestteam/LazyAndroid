package demoTest.bean;

import io.appium.java_client.AppiumDriver;
import lazy.android.annotations.Description;
import lazy.android.annotations.Xpath;
import lazy.android.bean.BaseBean;
import lazy.android.controls.Click;

/** 
 * @author huangshuli@jd.com
 * @date 2016年8月1日 下午4:00:12 
 * @version 1.0 
 * @remark
 */
public class UpdateBean extends BaseBean {

    @Xpath(xpath={"	//android.widget.Button[@resource-id='com.wangyin.payment:id/btn_cancel']"})
    @Description(description="Click cancelUpdate")
    public Click cancelUpdate;

	public UpdateBean(AppiumDriver aDriver) {
		super(aDriver);
		// TODO Auto-generated constructor stub
	}

}
