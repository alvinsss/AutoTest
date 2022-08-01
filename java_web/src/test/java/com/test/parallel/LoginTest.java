package com.test.parallel;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
* @Title: LoginTest
* @Description: 
* @author: alvin
* @date 2022年8月1日 上午9:10:41
*/
public class LoginTest {
	
	public static int a = 1;
	private Logger logger = Logger.getLogger(LoginTest.class);
	
	@Test
	public void testLoginFailure() throws InterruptedException{
		logger.info("登录的反向测试用例");
		Thread.sleep(2000);
		a++;
		
	}
	
	@Test
	public void testLoginSuccess() throws InterruptedException{
		logger.info("登录的正向测试用例");
		Thread.sleep(2000);
		a++;
	}
	
	@AfterTest
	public void tearDown(){
		logger.info("当前LoginTest类里面a的值："+a);
	}
	


}
