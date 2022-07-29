
package com.alvin.testcases;

import java.awt.Container;

import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.businessflow.IndexButtonClick;
import com.alvin.businessflow.LoginFlow;
import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.testdata.Constant;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;
 
/**
* @Title: IndexButtonTest
* @Description: 
* @author: alvin
* @date 2022年7月28日 下午12:42:32
*/
public class IndexLinkClickTest {
	
	 
	
	@Parameters({"browerName"})
	@BeforeMethod
	public void setUp(String browerName) throws Exception {
		System.out.println("IndexLinkClickTest BeforeTest");
		BrowserUtil.OpenBrowser(browerName);
		BrowserUtil.driver.get(Constant.LOGIN_URL);
		BrowserUtil.driver.manage().window().maximize();
	}
	
	@Test(description = "测试首页链接")
   public void test_LinkClick() throws Exception  {
	   //需要登录才能点击
		BrowserUtil.switchWindow("用户登录 - 禅道");
		LoginFlow loginFlow = new LoginFlow(LoginDatas.CORRECT_ACCOUNT,LoginDatas.CORRECT_PASSWORD);
		loginFlow.login();
	    Thread.sleep(1000);
	   
	   IndexButtonClick indexPageLink = new IndexButtonClick();
	   indexPageLink.testClick();
	   
   }
	
	@AfterMethod
	public void tearDown() {
		BrowserUtil.closeBrowser();

	}
	
}	
