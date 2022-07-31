
package com.alvin.testcases;

import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.testdata.Constant;
import com.alvin.util.BrowserUtil;
import com.beust.jcommander.Parameter;

/**
* @Title: IndexButtonTest
* @Description: 
* @author: alvin
* @date 2022年7月28日 下午12:42:32
*/
public class TestCaseDemoFile {
	
	@Parameters({"browerName"})
	@BeforeMethod
	public void setUp(String browerName) {
		BrowserUtil.OpenBrowser(browerName);
		BrowserUtil.driver.get(Constant.LOGIN_URL);
		BrowserUtil.driver.manage().window().maximize();
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@AfterMethod
	public void tearDown() {
		BrowserUtil.driver.quit();
	}
	
}	
