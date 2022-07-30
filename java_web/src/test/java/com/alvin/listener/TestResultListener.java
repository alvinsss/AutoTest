
package com.alvin.listener;

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
		addAttachment();
		String filePath = System.getProperty("user.dir")+"\\target\\screenshot\\";
		String fileName =System.currentTimeMillis()+".png";
		BrowserUtil.takesScreenshot(filePath+fileName);
	}
 
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
		//自定义成功操作
	}
	/**
	 * 用例失败返回
	 * @return
	 */
	@Attachment
	public String  addAttachment() {
		return "hello java 17";
	}
	
	
}
