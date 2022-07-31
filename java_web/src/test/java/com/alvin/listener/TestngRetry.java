
package com.alvin.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
* @Title: TestngRetry
* @Description: 
* @author: alvin
* @date 2022年7月31日 上午8:53:44
*/
public class TestngRetry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		//false表示不会重试
		return true;
	}

}
