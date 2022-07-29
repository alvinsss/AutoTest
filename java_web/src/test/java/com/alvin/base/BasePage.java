
package com.alvin.base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alvin.util.BrowserUtil;

/**
* @Title: BasePage
* @Description: 页面父类
* @author: alvin
* @date 2022年7月27日 下午6:00:22
*/
public class BasePage {
	
	
	/**
	 *  元素是否可见
	 * @param by
	 * @return WebElement
	 */
	public WebElement WaitElementVisible(By by) {
 		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.driver, Duration.ofSeconds(10));
		WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElement;
	}
	
	/**
	 * 元素是否可点击
	 * @param by
	 * @return webElement
	 */
	public WebElement WaitElementClickable(By by) {
 		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.driver, Duration.ofSeconds(10));
		WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		return webElement;
	}
	/**
	 * 点击操作
	 * @param by
	 */
	public void click(By by) {
		WaitElementClickable(by).click();
	}
	/***
	 * 输入数据
	 * @param by
	 * @param data
	 */
	public void input_type(By by,String data) {
		WaitElementVisible(by).clear();
		WaitElementVisible(by).sendKeys(data);
	}
	/***
	 * 获取元素文本
	 * @param by
	 * @return  String
	 */
	public String getElementText(By by) {
		String text = WaitElementVisible(by).getText();
		return text;
	}
	
	/**
	 * 获取元素属性
	 * @param by
	 * @param By by ,String attrName
	 * @return attribute
	 */
	public String getElementAttribute(By by ,String attrName) {
		String attribute = WaitElementVisible(by).getAttribute(attrName);
		return attribute;
	}
	
	/**
	 * 获取alert文本
	 * @return  String
	 */
	public static String _getAlertText() {
		Alert alert = BrowserUtil.driver.switchTo().alert();
		return alert.getText();
	}
	
	/**
	 * 点击alert确认按钮
	 */
	public static void _click_AlertDismiss() {
		Alert alert = BrowserUtil.driver.switchTo().alert();
		alert.dismiss();
	}
}
