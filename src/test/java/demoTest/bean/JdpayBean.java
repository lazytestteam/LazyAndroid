package demoTest.bean;

import io.appium.java_client.AppiumDriver;
import lazy.android.annotations.Description;
import lazy.android.annotations.Xpath;
import lazy.android.bean.BaseBean;
import lazy.android.controls.View;


/** 
 * @author huangshuli@jd.com
 * @date 2016年8月1日 下午3:25:27 
 * @version 1.0 
 * @remark
 */
public class JdpayBean extends BaseBean {

    @Xpath(xpath={"//android.widget.RelativeLayout[@resource-id='com.wangyin.payment:id/tabview_today']/android.widget.ImageView[1]"})
    @Description(description="View today")
    public View today;

    @Xpath(xpath={"//android.widget.RelativeLayout[@resource-id='com.wangyin.payment:id/tabview_finance']/android.widget.ImageView[1]"})
    @Description(description="View finance")
    public View finance;
    
    @Xpath(xpath={"//android.widget.RelativeLayout[@resource-id='com.wangyin.payment:id/tabview_life']/android.widget.ImageView[1]"})
    @Description(description="View life")
    public View life;
    
    @Xpath(xpath={"//android.widget.RelativeLayout[@resource-id='com.wangyin.payment:id/tabview_mine']/android.widget.ImageView[1]"})
    @Description(description="View mine")
    public View mine;
    
	public JdpayBean(AppiumDriver aDriver) {
		super(aDriver);
		// TODO Auto-generated constructor stub
	}

}
