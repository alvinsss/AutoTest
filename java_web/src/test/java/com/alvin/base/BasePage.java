
package com.alvin.base;

import java.time.Duration;

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

}
