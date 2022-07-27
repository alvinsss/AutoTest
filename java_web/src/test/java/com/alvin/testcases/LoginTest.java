
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

import com.alvin.pageobject.LoginPage;
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
		loginPage.inputUserAccount("admin");
		loginPage.inputPassword("123456abcd");
		loginPage.clickLoginButton();
		Thread.sleep(1000);
		//断言1 判断url地址
		System.out.println("getCurrentUrl->"+BrowserUtil.driver.getCurrentUrl());
		String expectedValue="http://localhost/zentaopms/www/index.php?m=my&f=index";
		String actualValue=BrowserUtil.driver.getCurrentUrl();
		Assert.assertEquals(actualValue, expectedValue);
		
		//断言2 判断登录之后是否有退出按钮
 		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.driver, Duration.ofSeconds(10));
 		//元素可见
		WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='退出']")));
		Assert.assertTrue(webElement.isDisplayed());
		System.out.println("isDisplayed:"+webElement.isDisplayed());
		BrowserUtil.driver.findElement(By.xpath("//a[text()='退出']")).click();
	}

	@Test
	public void login_dfailure() throws Exception {
		System.out.println("test login_failure");
		LoginPage loginPage = new LoginPage();
		loginPage.inputUserAccount("admin");
		loginPage.inputPassword("123456abc");
		loginPage.clickLoginButton();
		Thread.sleep(1000);
		Alert alert = BrowserUtil.driver.switchTo().alert();

		//断言1 alert文本是否与预期一致
 		String expectedValue="登录失败，请检查您的用户名或密码是否填写正确。";
 		System.out.println("getText:"+alert.getText());
		String actualValue=alert.getText();
		Assert.assertEquals(actualValue, expectedValue);
		alert.accept();
	}
		
		
	@AfterTest
	public void tearDown() {
		System.out.println("@AfterTest");
		BrowserUtil.driver.quit();
	}
	
}
