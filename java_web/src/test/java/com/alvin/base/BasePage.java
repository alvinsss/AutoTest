
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
	 * @return
	 */
	public WebElement WaitElementClickable(By by) {
 		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.driver, Duration.ofSeconds(10));
		WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		return webElement;
	}
	
	public void click(By by) {
		WaitElementClickable(by).click();
	}
	
	public void input_type(By by,String data) {
		WaitElementVisible(by).clear();
		WaitElementVisible(by).sendKeys(data);
	}
	
	public static String _getAlertText() {
		Alert alert = BrowserUtil.driver.switchTo().alert();
		return alert.getText();
	}
	
	public static void _click_AlertDismiss() {
		Alert alert = BrowserUtil.driver.switchTo().alert();
		alert.dismiss();
	}
}
