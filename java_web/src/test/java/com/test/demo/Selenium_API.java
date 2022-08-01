
package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
* @Title: Selenium_API
* @Description: 
* @author: alvin
* @date 2022年7月26日 上午10:41:57
*/
public class Selenium_API {
	
	public static void main(String[] args) throws Exception {
		WebDriver driver = OpenBrowser.OpenBrowserDriver("firefox");
		driver.get("http://www.baidu.com");
//		driver.findElement(By.id("kw")).sendKeys("qa");
//		Thread.sleep(1000);
//		driver.findElement(By.id("kw")).clear();
//		driver.findElement(By.id("kw")).sendKeys("qatest");
//		//全选
//		driver.findElement(By.id("kw")).sendKeys(Keys.CONTROL,"a");
//		Thread.sleep(2000);
//		//复制
//		driver.findElement(By.id("kw")).sendKeys(Keys.CONTROL,"c");
//		Thread.sleep(2000);
//		//粘贴
//		driver.findElement(By.id("kw")).sendKeys(Keys.CONTROL,"v");
//		Thread.sleep(2000);
//		//粘贴
//		driver.findElement(By.id("kw")).sendKeys(Keys.CONTROL,"v");
//		driver.findElement(By.id("su")).click();
		WebElement element = driver.findElement(By.linkText("图片"));
 		System.out.println(element.getText());
		System.out.println(element.getAttribute("href"));
		System.out.println(element.getTagName());
		//isDisplayed看元素是否显示 true
		element.isDisplayed();
		System.out.println(element.isDisplayed());
		element.click();

	}
	
	
}
