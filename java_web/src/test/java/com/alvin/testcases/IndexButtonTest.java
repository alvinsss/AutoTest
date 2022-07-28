
package com.alvin.testcases;

import java.awt.Container;

import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;
import com.alvin.util.Constant;
import com.beust.jcommander.Parameter;

/**
* @Title: IndexButtonTest
* @Description: 
* @author: alvin
* @date 2022年7月28日 下午12:42:32
*/
public class IndexButtonTest {
	
	 
	
	@Parameters({"browerName"})
	@BeforeTest
	public void setUp(String browerName) throws Exception {
		BrowserUtil.OpenBrowser(browerName);
		BrowserUtil.driver.get(Constant.LOGIN_URL);
		BrowserUtil.driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	@Test
	public void testButton() throws Exception {
		System.out.println("IndexButtonTest");
		LoginPage loginpage = new LoginPage();
		loginpage.inputUserAccount(LoginDatas.CORRECT_ACCOUNT);
		loginpage.inputPassword(LoginDatas.CORRECT_PASSWORD);
		loginpage.clickLoginButton();
		Thread.sleep(1000);
		System.out.println("Login is OK");
		IndexPage indexpage = new IndexPage();
//		indexpage.buttonMyHome();
		indexpage.buttonProduct();
		indexpage.buttonProject();
		indexpage.buttonQa();
		BrowserUtil.driver.navigate().back();
		indexpage.buttonDoc();
		indexpage.buttonReport();
//		indexpage.buttonBackadmin();
//		indexpage.buttonCompany();
//		indexpage.buttonAbout();
		indexpage.buttonHelp();
		BrowserUtil.driver.navigate().back();
		Thread.sleep(1000);
//		indexpage.buttonHelpSC();
		BrowserUtil.driver.navigate().refresh();
	}
	
	@AfterTest
	public void tearDown() {
		BrowserUtil.driver.quit();
	}
	
}	
