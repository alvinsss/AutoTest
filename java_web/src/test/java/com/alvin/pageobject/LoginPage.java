
package com.alvin.pageobject;

import org.openqa.selenium.By;

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
		BrowserUtil.driver.findElement(useraccountBy).clear();
		BrowserUtil.driver.findElement(useraccountBy).sendKeys(account);
	}
	
	public void inputPassword(String password) {
		BrowserUtil.driver.findElement(passwordBy).clear();
		BrowserUtil.driver.findElement(passwordBy).sendKeys(password);
	}
	
	public void clickLoginButton( ) {
		BrowserUtil.driver.findElement(submitBy).click();
	}
}
