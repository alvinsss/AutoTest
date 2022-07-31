
package com.alvin.listener;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.alvin.util.BrowserUtil;

import io.qameta.allure.Attachment;

/**
* @Title: TestResultListener
* @Description: 
* @author: alvin
* @date 2022年7月30日 上午9:51:26
*/
public class TestResultListener extends TestListenerAdapter {

	private static Logger logger = Logger.getLogger(TestResultListener.class);

		
	/**
	 * 继承TestListenerAdapter类重写onTestFailure方法，表示用例执行失败监听
	 */
	@Override
	public void onTestFailure(ITestResult tr) {
		// 调用父类方法
		super.onTestFailure(tr);
		//做一些相关的操作--截图，TestResultListener对所有监听类生效
		
		System.currentTimeMillis();
		//工程路径
		System.getProperty("user.dir");
		
		//用例失败返回备注文字和失败截图方便allure展示
		addAttachmentTakesScreenshot();
		
		String filePath = System.getProperty("user.dir")+"\\target\\screenshot\\";
		String fileName =System.currentTimeMillis()+".png";
		BrowserUtil.takesScreenshot(filePath+fileName);
		//全部的重试运行完，用例结果失败 我们需要把currentRetryCount设置1
		TestngRetry.currentRetryCount=1;
		logger.info("onTestFailure reset:"+TestngRetry.currentRetryCount);
	}
 
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
		//自定义成功操作 [ERROR] Tests run: 4, Failures: 2, Errors: 0, Skipped: 1
		//当执行第1次重试失败 用例通过的，当执行第2次重试的时候，用例通过的
		TestngRetry.currentRetryCount=1;
		logger.info("onTestSuccess reset:"+TestngRetry.currentRetryCount);


	}
	
	
	/**
	 * 用例失败返回固定的备注文字方便allure展示
	 * @return
	 */
	@Attachment
	public String  addAttachment() {
		return "hello Screenshot addAttachment ";
	}
	
	
	/**
	 *  
	 * @return 用例失败返回备注文字和失败截图方便allure展示
	 */
	@Attachment(value = "current case page screenshot", type = "image/png")
	public byte[] addAttachmentTakesScreenshot(){
		logger.info(" addAttachmentTakesScreenshot  is running...");
		return BrowserUtil.takesScreenshot();
	}
	
}
