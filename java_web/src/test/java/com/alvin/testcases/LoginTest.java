
package com.alvin.testcases;

import java.sql.Connection;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;
import com.alvin.util.Constant;
 
/**
* @Title: LoginTest
* @Description: 
* @author: alvin
* @date 2022年7月27日 下午2:05:06
*/
public class LoginTest {
	
 	
	
	@Parameters({"browerName"})
	@BeforeTest
	public void setUp(String browerName) {
		System.out.println("BeforeTest current brower->"+browerName);
		BrowserUtil.OpenBrowser(browerName);
		BrowserUtil.driver.get(Constant.LOGIN_URL);
		BrowserUtil.driver.manage().window().maximize();
	}

	@Test
	public void login_asuccess() throws Exception {
		System.out.println("test login_success");
		LoginPage loginPage = new LoginPage();
		IndexPage indexPage = new IndexPage();
		loginPage.inputUserAccount(LoginDatas.CORRECT_ACCOUNT);
		loginPage.inputPassword(LoginDatas.CORRECT_PASSWORD);
		loginPage.clickLoginButton();
		Thread.sleep(1000);
		//断言1 判断url地址
		String expectedValue=Constant.INDEX_URL;
		String actualValue=BrowserUtil.driver.getCurrentUrl();
		Assert.assertEquals(actualValue, expectedValue);
		
		//断言2 判断登录之后是否有退出按钮
		Assert.assertTrue(indexPage.isDisplayed_ButtonQuit());
		indexPage.buttonQuit();
	}
	
	/**
	 *  dataProvider注解返回2维数组，可以多次执行不同情况的测试
	 * @throws Exception
	 */
	@Test(description = "", dataProviderClass = LoginDatas.class, dataProvider = "getLoginFailureDatas")
	public void login_dfailure_01(String account,String password, String expectedValue) throws Exception {
		System.out.println("test login_failure");
		System.out.println("account:"+account+"   password:"+password+"  expect:"+expectedValue);
		LoginPage loginPage = new LoginPage();
		loginPage.inputUserAccount(account);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		Thread.sleep(1000);
		//断言1 alert文本是否与预期一致
 		String actualValue=loginPage.getAlertText();
		Assert.assertEquals(actualValue, "登录失败，请检查您的用户名或密码是否填写正确。");
		loginPage.click_AlertDismiss();
	}
	

		
	@AfterTest
	public void tearDown() {
		System.out.println("@AfterTest");
		BrowserUtil.driver.quit();
	}
	
}
