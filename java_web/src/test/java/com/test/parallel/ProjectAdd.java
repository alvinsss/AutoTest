package com.test.parallel;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
* @Title: ProjectAdd
* @Description: 
* @author: alvin
* @date 2022年8月1日 上午9:13:41
*/
public class ProjectAdd {
	
	public static int a = 1;
	private Logger logger = Logger.getLogger(ProjectAdd.class);
	
	@Test
	public void testProjectAddFailure() throws InterruptedException{
		logger.info("项目添加反向测试用例");
		Thread.sleep(2000);
		a++;
		
	}
	
	@Test
	public void testProjectAddSuccess() throws InterruptedException{
		logger.info("项目添加的正向测试用例");
		Thread.sleep(2000);
		a++;
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("当前LoginTest类里面a的值："+a);
	}
	


}
