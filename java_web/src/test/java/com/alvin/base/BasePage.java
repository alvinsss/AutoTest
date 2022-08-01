
package com.alvin.base;

import java.time.Duration;
import java.util.Set;

import org.apache.log4j.Logger;
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
	
	private static Logger logger = Logger.getLogger(BasePage.class);
	/**
	 *  元素是否可见
	 * @param by
	 * @return WebElement
	 */
	public WebElement WaitElementVisible(By by) {
 		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.getDriver(), Duration.ofSeconds(10));
		WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return webElement;
	}
	
	/**
	 * 元素是否可点击
	 * @param by
	 * @return webElement
	 */
	public WebElement WaitElementClickable(By by) {
 		WebDriverWait webDriverWait = new WebDriverWait(BrowserUtil.getDriver(), Duration.ofSeconds(10));
		WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		return webElement;
	}
	/**
	 * 点击操作
	 * @param by
	 */
	public void click(By by) {
		WaitElementClickable(by).click();
		logger.info("点击了元素["+by+"]");
	}
	/***
	 * 输入数据
	 * @param by
	 * @param data
	 */
	public void input_type(By by,String data) {
		WaitElementVisible(by).clear();
		WaitElementVisible(by).sendKeys(data);
		logger.info("给元素["+by+"] 输入键值["+data+"] ");

	}
	/***
	 * 获取元素文本
	 * @param by
	 * @return  String
	 */
	public String getElementText(By by) {
		String text = WaitElementVisible(by).getText();
		logger.info("元素["+by+"] 的Text是["+text+"] ");

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
		logger.info("元素["+by+"] 的["+attrName+"]值是["+attrName+"] ");
		return attribute;
	}
	
	/**
	 * 获取alert文本
	 * @return  String
	 */
	public static String _getAlertText() {
		Alert alert = BrowserUtil.getDriver().switchTo().alert();
		logger.info("获取Alert文本内容:"+alert.getText());
		return alert.getText();
	}
	
	/**
	 * 点击alert确认按钮
	 */
	public static void _click_AlertDismiss() {
		Alert alert = BrowserUtil.getDriver().switchTo().alert();
		logger.info("点击Alert的确定按钮");
		alert.dismiss();
	}

}
