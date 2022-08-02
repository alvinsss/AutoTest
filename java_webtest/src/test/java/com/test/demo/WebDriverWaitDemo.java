
package com.test.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* @Title: Wait
* @Description: 
* @author: alvin
* @date 2022年7月26日 下午3:20:56
*/
public class WebDriverWaitDemo {
	
	public static void main(String[] args) {
		
		//1、固定等待
		//Thread.sleep(3000);
		//2、隐式等待 间隔轮询是不是找到了元素--元素在当前页面存在
		WebDriver driver = OpenBrowser.OpenBrowserDriver("chrome");
		//设置隐式等待的超时事件 -- 超时时间5S 在这5S内会一直不断的循环找元素
		//findElement/findElements找元素才会有隐式等待的效果
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get("https://www.ketangpai.com/");
		/*driver.findElement(By.id("kw")).sendKeys("柠檬班");
		driver.findElement(By.id("su")).click();
		driver.findElement(By.xpath("//a[text()='_腾讯课堂']")).click();
		*/
		//WebElement webElement = driver.findElement(By.xpath("//a[text()='申请机构版']"));
	
		driver.get("https://www.ketangpai.com/");
		//3、显示等待
		//（1）、初始化WebDriverWait对象,timeOutInSeconds --》超时时间
		//每间隔500ms轮询这个元素的条件是不是满足的
		WebDriverWait webDriverWait =new WebDriverWait(driver, Duration.ofSeconds(10));

		//（2）、调用webdriverwait对象的until方法 -- 直到条件满足时为止
		//presenceOfElementLocated-->webDriverwait自带的条件  元素在当前页面中存在
		//locator--》by对象(描述的元素的定位)
		//TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath
		//超时异常：期望的条件失败了：等待这个元素可见
		WebElement webElement = webDriverWait.until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//a[text()='申请机构版']")));
		webElement.click();
	}
}
