
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
	private int maxRetryCount = 3;
	// 当前的重试次数
	public static int currentRetryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		// 默认返回为false就表示不会执行重试机制
		// 返回为true导致死循环，所以我们需要加入逻辑控制
		if (currentRetryCount <= maxRetryCount) {
			logger.info("--------当前的重试次数【" + currentRetryCount + "】---------");
			currentRetryCount++;
			return true;
		} else {
			return false;
		}

	}
}
