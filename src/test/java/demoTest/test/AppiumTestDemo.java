package demoTest.test;

import lazy.android.common.Find;
import lazy.android.common.LazyDriver;
import lazy.android.common.PhoneOperations;
import lazy.android.controls.ControlType;
import lazy.android.controls.Select;
import mx4j.log.Logger;
import io.appium.java_client.AppiumDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demoTest.bean.JdpayBean;
import demoTest.bean.LifeBean;
import demoTest.bean.TestBean;
import demoTest.bean.UpdateBean;
import demoTest.bean.Welcome1Bean;
import demoTest.bean.WelcomeBean;

public class AppiumTestDemo {
	private AppiumDriver driver;
//	private TestBean bean;
	private Welcome1Bean helloBean;
	private WelcomeBean goBean;
	private UpdateBean updateBean;
	private JdpayBean bean;
	private LifeBean lifeBean;
	private PhoneOperations operation;

    @BeforeClass
    public void setUp() throws Exception {
    
        // driver = LazyDriver.getSimpleAppDriver("SimpleApp.apk", "simple.app", ".SimpleAppActivity", "4.2.2");       
    	driver = LazyDriver.getSimpleAppDriver("jdpay.apk", "com.wangyin.payment", ".splash.ui.SplashActivity", "4.2.2");
    	
//    	bean = new TestBean(driver);
    	helloBean = new Welcome1Bean(driver);
    	goBean = new WelcomeBean(driver);
    	updateBean = new UpdateBean(driver);
    	bean = new JdpayBean(driver);
    	lifeBean = new LifeBean(driver);
    	operation = new PhoneOperations(driver);
}

 
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    @Test
    public void helloTest() throws InterruptedException{
   	
//        boolean b1 = bean.button.isExists();
//        bean.button.click();
//        String text1 = bean.button.getText();
//        Thread.sleep(500);
//        
//        boolean b2 = bean.check.isExists();
//        bean.check.check();
////        String text2 = bean.check.getText();
//        Thread.sleep(500);
//        boolean b3 = bean.check.isChecked();
//        bean.check.unCheck();
//        boolean b4 = bean.check.isChecked();
////        Thread.sleep(500);
////        
////        boolean b5 = bean.radio.isExists();
//        bean.radio.check();
//        boolean b6 = bean.radio.isChecked();
//        bean.check.unCheck();
//        boolean b7 = bean.radio.isChecked();
////        Thread.sleep(500);
//       	

//        boolean bTest = bean.digitalClock.isExists();
//        bean.digitalClock.click();
//        swipe.swipeUp(500);
//        
//        String aa = bean.digitalClock.getText();
//        
//        System.out.print(bTest + aa);
//        
//    	swipe.swipeToLeft(500);
    	
//        bean.editText.input("你好");
//        Thread.sleep(500);
//        bean.editText.clear();
//        bean.editText.input("hello");
//        String text3 =  bean.editText.getText();
//        ControlType a = bean.editText.getType();
//        
//        String str = bean.plainText.getText();
//        System.out.print(str);
//        Thread.sleep(500);

    
    	//welcome page
    	//Thread.sleep(5000);
    	helloBean.hello.expectElementExistOrNot(true, 10000);
    	operation.swipeToLeft(500);
    	Thread.sleep(500);
    	
    	goBean.go.click();
    	Thread.sleep(1000);
    	
  //  	helloBean.hello.expectElementExistOrNot(true, 5000);  //测试找不到元素能否抛异常
    	
        //	updateBean.cancelUpdate.expectElementExistOrNot(true,3000);
     	if (updateBean.cancelUpdate.isExists())
     		updateBean.cancelUpdate.click();
    	Thread.sleep(500);
    	
    	//page
    	bean.finance.click();
    	Thread.sleep(500);
    	
    	bean.life.click();
    	Thread.sleep(500);
    	
    	operation.swipeDown(500);
    	Thread.sleep(500);
    	
    	operation.swipeToLeft(500);
    	Thread.sleep(500);
    	
    	lifeBean.transferAccounts.click();
    	Thread.sleep(500);
    	driver.sendKeyEvent(4);
    	Thread.sleep(5000);

    }
}
