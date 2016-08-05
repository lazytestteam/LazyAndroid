package demoTest.bean;

import io.appium.java_client.AppiumDriver;
import lazy.android.annotations.Description;
import lazy.android.annotations.FullIndexXpath;
import lazy.android.annotations.Xpath;
import lazy.android.bean.BaseBean;
import lazy.android.controls.Click;
import lazy.android.controls.PlainText;
import lazy.android.controls.View;

/**
 * 自动生成的bean层代码 
 * @author Auto_Generator
 * @date 2016年8月4日 上午10:04:56
 * @version 1.0 
 * @remark
 */

public class AutoGenBean extends BaseBean{

@Xpath(xpath={"//android.widget.TextView[@resource-id='com.wangyin.payment:id/title_text']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
@Description(description="android.widget.TextView")
public  PlainText  TextView1;


@Xpath(xpath={"//android.widget.TextView[@text='1']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
@Description(description="android.widget.TextView")
public  PlainText  TextView2;


@Xpath(xpath={"//android.widget.TextView[@text='新增京东旺财·月月盈—4.8%年化收益率']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]")
@Description(description="android.widget.TextView")
public  PlainText  TextView3;


@Xpath(xpath={"//android.widget.TextView[@text='2']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
@Description(description="android.widget.TextView")
public  PlainText  TextView4;


@Xpath(xpath={"//android.widget.TextView[@text='新增资产管家，最贴心的资产助手']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]")
@Description(description="android.widget.TextView")
public  PlainText  TextView5;


@Xpath(xpath={"//android.widget.TextView[@text='3']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")
@Description(description="android.widget.TextView")
public  PlainText  TextView6;


@Xpath(xpath={"//android.widget.TextView[@text='新增定期还款，还房贷、还车贷']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.TextView[2]")
@Description(description="android.widget.TextView")
public  PlainText  TextView7;


@Xpath(xpath={"//android.widget.TextView[@text='4']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")
@Description(description="android.widget.TextView")
public  PlainText  TextView8;


@Xpath(xpath={"//android.widget.TextView[@text='付款码新增白条支付入口']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.TextView[2]")
@Description(description="android.widget.TextView")
public  PlainText  TextView9;


@Xpath(xpath={"//android.widget.LinearLayout[@resource-id='com.wangyin.payment:id/btn_layout']/android.view.View[1]"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.view.View[1]")
@Description(description="android.view.View")
public  View  android_view_View1;


@Xpath(xpath={"//android.widget.Button[@resource-id='com.wangyin.payment:id/btn_cancel']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.Button[1]")
@Description(description="android.widget.Button")
public  Click  Button1;


@Xpath(xpath={"//android.view.View[@resource-id='com.wangyin.payment:id/view_splider']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.view.View[1]")
@Description(description="android.view.View")
public  View  android_view_View2;


@Xpath(xpath={"//android.widget.Button[@resource-id='com.wangyin.payment:id/btn_ok']"})
@FullIndexXpath(fullIndexXpath="//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.Button[2]")
@Description(description="android.widget.Button")
public  Click  Button2;


public AutoGenBean(AppiumDriver aDriver) {
		super(aDriver);
		// TODO Auto-generated constructor stub
	}

}