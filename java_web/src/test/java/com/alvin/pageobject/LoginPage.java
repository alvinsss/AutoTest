
package com.alvin.pageobject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alvin.base.BasePage;
import com.alvin.testcases.LoginTest;
import com.alvin.util.BrowserUtil;

/**
* @Title: LoginPage 
* @Description:  登录页面对象
* @author: alvin
* @date 2022年7月27日 下午4:23:18
*/
public class LoginPage extends BasePage{
	
	private  By useraccountBy = By.name("account");
	private  By passwordBy = By.name("password");
	private  By submitBy = By.id("submit");
	
	public void inputUserAccount(String account) {
		WaitElementVisible(useraccountBy).clear();
		input_type(useraccountBy, account);
	}
	
	public void inputPassword(String password) {
		WaitElementVisible(passwordBy).clear();
		input_type(passwordBy, password);
	}
	
	public void clickLoginButton( ) {
//		WaitElementClickable(submitBy).click();
		click(submitBy);
	}
	
	//获取alert文本
	public String getAlertText() {
		return BasePage._getAlertText();
	}
	
	//提示alert点击确定
	public static void click_AlertDismiss() {
		BasePage._click_AlertDismiss();
	}
}
