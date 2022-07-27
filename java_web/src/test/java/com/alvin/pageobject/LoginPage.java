
package com.alvin.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alvin.testcases.LoginTest;
import com.alvin.util.BrowserUtil;

/**
* @Title: LoginPage 
* @Description:  登录页面对象
* @author: alvin
* @date 2022年7月27日 下午4:23:18
*/
public class LoginPage {
	
	private  By useraccountBy = By.name("account");
	private  By passwordBy = By.name("password");
	private  By submitBy = By.id("submit");
	
	public void inputUserAccount(String account) {
		WaitElementVisible(useraccountBy).clear();
		WaitElementVisible(useraccountBy).sendKeys(account);
	}
	
	public void inputPassword(String password) {
		WaitElementVisible(passwordBy).clear();
		WaitElementVisible(passwordBy).sendKeys(password);
	}
	
	public void clickLoginButton( ) {
		WaitElementVisible(submitBy).click();
	}
	
	public WebElement WaitElementVisible(By by) {
 		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.driver, Duration.ofSeconds(10));
 		//元素可见
		WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElement;
	}
	
}
