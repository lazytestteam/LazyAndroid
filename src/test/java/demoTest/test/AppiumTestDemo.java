package demoTest.test;

import demoTest.bean.*;
import io.appium.java_client.AppiumDriver;
import lazy.android.common.LazyDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumTestDemo {
	private AppiumDriver driver;
	private TestBean bean;
//	private Welcome1Bean helloBean;
//	private WelcomeBean goBean;
//	private UpdateBean updateBean;
//	private JdpayBean bean;
//	private LifeBean lifeBean;
//	private PhoneOperations operation;

	private LazyDriver lazyDriver;
	
    @BeforeClass
    public void setUp() throws Exception {
    
        lazyDriver = new LazyDriver("SimpleApp.apk", "simple.app", ".SimpleAppActivity", "4.2.2", true);
    	driver = lazyDriver.getDriver();

    	bean = new TestBean(driver);
//    	helloBean = new Welcome1Bean(driver);
//    	goBean = new WelcomeBean(driver);
//    	updateBean = new UpdateBean(driver);
//    	bean = new JdpayBean(driver);
//    	lifeBean = new LifeBean(driver);
//    	operation = new PhoneOperations(driver);
}

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    @Test
    public void helloTest() throws InterruptedException{
   	
    	bean.button1.expectElementExistOrNot(true,3000);
        boolean b1 = bean.button1.isExists();
        String str = bean.textView2.getText();
       // lazyDriver.expectTextExistOrNot(true, "textView");
        lazyDriver.expectTextExistOrNot(true, "TextView");
        lazyDriver.expectTextExistOrNot(false, "textView");
//        WebElement wlText = bean.textView2.toWebElement();
//        WebElement wlButton = bean.button1.toWebElement();
        
        
        WebElement wl = lazyDriver.findElementByText(str);
        WebElement wl2 = lazyDriver.findElementByText(bean.checkBox1.getText());
        WebElement wl3 = lazyDriver.findElementByText(bean.radioButton1.getText(),"RadioButton");
        WebElement wl5 = lazyDriver.findElementByText(bean.ToggleButton1.getText(),"ToggleButton");
        lazyDriver.swipeToLeft(500);
        lazyDriver.swipeToRight(500);
        lazyDriver.swipeUp(500);
        lazyDriver.swipeDown(500);
        
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
//    	  swipe.swipeToLeft(500);
    	
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

    
//    	//welcome page
//    	//Thread.sleep(5000);
//    	helloBean.hello.expectElementExistOrNot(true, 10000);
//    	operation.swipeToLeft(500);
//    	Thread.sleep(500);
//    	
//    	goBean.go.click();
//    	Thread.sleep(1000);
//    	
//  //  	helloBean.hello.expectElementExistOrNot(true, 5000);  //测试找不到元素能否抛异常
//    	
//        //	updateBean.cancelUpdate.expectElementExistOrNot(true,3000);
//     	if (updateBean.cancelUpdate.isExists())
//     		updateBean.cancelUpdate.click();
//    	Thread.sleep(500);
//    	
//    	//page
//    	bean.finance.click();
//    	Thread.sleep(500);
//    	
//    	bean.life.click();
//    	Thread.sleep(500);
//    	
//    	lazyDriver.swipeDown(500);
//    	Thread.sleep(500);
//    	
//    	lazyDriver.swipeToLeft(500);
//    	Thread.sleep(500);
//    	
//    	lifeBean.transferAccounts.click();
//    	Thread.sleep(500);
//    	driver.sendKeyEvent(4);
//    	Thread.sleep(5000);

    }
}
