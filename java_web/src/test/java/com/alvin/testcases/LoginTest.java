
package com.alvin.testcases;

import java.sql.Connection;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.businessflow.LoginFlow;
import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.testdata.Constant;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;
  
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
		System.out.println("CreateProjectTest BeforeTest");
		BrowserUtil.OpenBrowser(browerName);
		BrowserUtil.driver.get(Constant.LOGIN_URL);
		BrowserUtil.driver.manage().window().maximize();
	}

	@Test(description = "正确的account ,password的用例")
	public void login_asuccess() throws Exception {
		System.out.println("test login_success");
		System.out.println(LoginDatas.CORRECT_ACCOUNT+"---->"+LoginDatas.CORRECT_PASSWORD);
		LoginFlow loginAction = new LoginFlow(LoginDatas.CORRECT_ACCOUNT,LoginDatas.CORRECT_PASSWORD);
		loginAction.login();
		Thread.sleep(1000);
		//断言1 判断url地址
		String expectedValue=Constant.INDEX_URL;
		String actualValue=BrowserUtil.driver.getCurrentUrl();
		System.out.println("actualValue:" + actualValue);
		Assert.assertEquals(actualValue, expectedValue);
		
		//断言2 判断登录之后是否有退出按钮
		IndexPage indexPage=new IndexPage();
		Assert.assertTrue(indexPage.isDisplayed_ButtonQuit());
		indexPage.buttonQuit();
	}
	
	/**
	 *  dataProvider注解返回2维数组，根据dataProviderClass.dataProvider的方法名指定数据
	 * @throws Exception
	 */
	@Test(description = "", dataProviderClass = LoginDatas.class, dataProvider = "getLoginFailureDatas")
	public void login_dfailure_getLoginFailureDatas(String account,String password, String expectedValue) throws Exception {
		LoginFlow loginAction = new LoginFlow(account,password);
		loginAction.login();
		Thread.sleep(1000);
		//断言1 alert文本是否与预期一致
		LoginPage loginPage = new LoginPage();
 		String actualValue=loginPage.getAlertText();
		Assert.assertEquals(actualValue, expectedValue);
		Thread.sleep(1000);
		loginPage.click_AlertDismiss();
	}
	
	@Test(description = "", dataProviderClass = LoginDatas.class, dataProvider = "getLoginErrorDatas")
	public void login_dfailure_getLoginErrorDatas(String account,String password, String expectedValue) throws Exception {
		System.out.println("account:"+account+"   password:"+password+"  expect:"+expectedValue);

		LoginFlow loginAction = new LoginFlow(account,password);
		loginAction.login();
		Thread.sleep(1000);
		
		//断言1 alert文本是否与预期一致
		LoginPage loginPage = new LoginPage();
 		String actualValue=loginPage.getAlertText();
 		System.out.println("actualValue"+actualValue);
 		System.out.println("expectedValue"+expectedValue);
		Assert.assertEquals(actualValue, expectedValue);
		Thread.sleep(1000);
		loginPage.click_AlertDismiss();
	}
	
		
	@AfterTest
	public void tearDown() {
		System.out.println("CreateProjectTest AfterTest");
		BrowserUtil.driver.quit();
	}
	
}
