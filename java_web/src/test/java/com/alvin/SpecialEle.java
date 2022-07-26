
package com.alvin;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* @Title: SpecialEle
* @Description: 
* @author: alvin
* @date 2022年7月26日 下午7:10:03
*/
public class SpecialEle {
	public static void main(String[] args) throws Exception {
		//1.alert 弹框
		WebDriver driver = OpenBrowser.OpenBrowserDriver("chrome");
//		driver.get("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\模态框\\alert.html");
//		driver.findElement(By.id("abtn")).click();
//		Thread.sleep(1000);
//		Alert alert = driver.switchTo().alert();
//		//接收
////		alert.accept();
//		System.out.println(alert.getText());
//		alert.dismiss();
		
//		2.confirm弹框
//		driver.get("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\模态框\\confirm.html");
//		driver.findElement(By.id("abtn")).click();
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
////		alert.accept();
//		alert.dismiss();
//		Thread.sleep(1000);
//		System.out.println(alert.getText());
//		alert.accept();
		
//		3.div类型弹框
//		driver.get("http://www.yidai.com/calculator/");
//		driver.findElement(By.id("account")).sendKeys("10000");
//		driver.findElement(By.id("period")).sendKeys("12");
//		driver.findElement(By.xpath("//*[@name='tiem' and @value='month'] ")).click();
//		driver.findElement(By.id("borrow_apr")).sendKeys("10");
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
//		driver.get("http://120.78.128.25:8765/");
//		driver.findElement(By.linkText("收益计算器")).click();
//		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement webElement = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("rate")));
//		webElement.sendKeys("18");
		
		//iframe
//		driver.get("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\iframe\\a.html");
//		driver.findElement(By.id("aa")).sendKeys("11");
//		Thread.sleep(2000);
//		WebElement element = driver.findElement(By.id("aa"));
//		System.out.println("a-->"+element.getAttribute("value"));
//		driver.switchTo().frame(0);
//		driver.findElement(By.id("bb")).sendKeys("22");
//		WebElement element2 = driver.findElement(By.id("bb"));
//		System.out.println("b-->"+element2.getAttribute("value"));
//		driver.switchTo().frame("cframe");
//		driver.findElement(By.id("cc")).sendKeys("33");
//		WebElement element3 = driver.findElement(By.id("cc"));
//		System.out.println("c-->"+element3.getAttribute("value"));
//		//默认内容
//		driver.switchTo().defaultContent();
//		driver.findElement(By.id("aa")).sendKeys("11aa");
		
		driver.get("https://www.baidu.com/");
		driver.findElement(By.xpath("//a[text()='新闻']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='hao123']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='视频']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		OpenBrowser.switchWindow(driver,"百度新闻——海量中文资讯平台");
		
		
	}
}
