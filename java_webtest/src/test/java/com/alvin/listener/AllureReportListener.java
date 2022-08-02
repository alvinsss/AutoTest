
package com.alvin.listener;

import org.apache.log4j.Logger;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import com.alvin.util.BrowserUtil;

import io.qameta.allure.Attachment;

/**
* @Title: AllureReportListener
* @Description: 
* @author: alvin
* @date 2022年8月1日 上午9:00:47
*/
public class AllureReportListener  implements IHookable{
	private static Logger logger = Logger.getLogger(AllureReportListener.class);
	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		// TODO Auto-generated method stub
		callBack.runTestMethod(testResult);
		System.out.println("testResult.getThrowable:"+testResult.getThrowable());
		logger.info("testResult.getTestClass:"+testResult.getTestClass());
		logger.info("testResult.getMethod:"+testResult.getMethod());
		logger.info("testResult.getDescription:"+testResult.getMethod().getDescription());
		//testResult保存测试结果 根据testResult有没有异常来进行截图
		if(testResult.getThrowable() != null) {
			//把getName写入allure
			saveScreenshot(testResult.getMethod().getDescription());
		}
	}
	/**
	 * @return 返回iHookable返回(testResult)info1给allure截图当做备注展示
	 */
	@Attachment(value = "Screenshot:{0}", type = "image/png")
	public static byte[] saveScreenshot(String info1){
		logger.info(" saveScreenshot  is running..."+info1);
		return BrowserUtil.screenshot();
	}
}
