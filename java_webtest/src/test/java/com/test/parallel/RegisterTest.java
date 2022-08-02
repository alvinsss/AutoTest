package com.test.parallel;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
* @Title: RegisterTest
* @Description: 
* @author: alvin
* @date 2022年8月1日 上午9:17:41
*/
public class RegisterTest {
	
	public static int a = 1;
	private Logger logger = Logger.getLogger(RegisterTest.class);
	
	@Test
	public void testRegisterFailure() throws InterruptedException{
		logger.info("注册的反向测试用例");
		Thread.sleep(2000);
		a++;
		
	}
	
	@Test
	public void testRegisterSuccess() throws InterruptedException{
		logger.info("注册的正向测试用例");
		Thread.sleep(2000);
		a++;
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("当前RegisterTest类里面a的值："+a);
	}


}
