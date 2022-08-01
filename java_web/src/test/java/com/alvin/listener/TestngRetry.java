
package com.alvin.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
* @Title: TestngRetry
* @Description: 
* @author: alvin
* @date 2022年7月31日 上午8:53:44
*/
public class TestngRetry implements IRetryAnalyzer{
	

	private Logger logger = Logger.getLogger(TestngRetry.class);

	// 规定重试次数最多跑多少次
	private int maxRetryCount = 2;
	// 只有断言失败的测试才能进入，所以当前的重试次数初始是1，static类型方便TestResultListener操作重置
//	public static int currentRetryCount = 1;
//  解决多线程安全问题
	private static ThreadLocal<Integer> retryCountThreadLocal = new ThreadLocal<Integer>();
 
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		// 默认返回为false就表示不会执行重试机制
		// 返回为true导致死循环，所以我们需要加入逻辑控制
		if (getRetryCount() <= maxRetryCount) {
			logger.info("--------当前的重试次数【" + getRetryCount() + "】---------");
			//先取数据再增加
			int currentRetryCount = getRetryCount();
			currentRetryCount++;
			//然后存回去
			setRetryCount(currentRetryCount);	
			return true;
		} else {
			return false;
		}

	}
	
	public static void setRetryCount(Integer retryCount) {
		retryCountThreadLocal.set(retryCount);
	}
	
	public static int getRetryCount() {
		return retryCountThreadLocal.get();
	}
}
