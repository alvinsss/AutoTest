
package com.test.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
* @Title: seleniumGridTest
* @Description: 
* @author: alvin
* @date 2022年8月2日 下午2:18:25
*/
public class seleniumGridTest {
	
	WebDriver driver;

	@Parameters({"browserName"})
	@BeforeTest
	public void setUp(String browserName) throws MalformedURLException {
		// 期望能力对象
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// 配置测试的浏览器
		capabilities.setBrowserName(browserName);
		//capabilities.setPlatform(Platform.LINUX);
		//capabilities.setVersion("68");
		// hub节点
		String url = "http://192.168.0.30:8888/wd/hub";
		// 和hub建立通讯，把相应配置传给hub，hub会根据配置选择注册的node节点，打开相应的浏览器进行测试
		driver = new RemoteWebDriver(new URL(url), capabilities);
		driver.get("http://192.168.0.30/zentaopms/www/index.php");
		
	}
	
	@Test
	public void testBaidu() throws InterruptedException{
		driver.findElement(By.id("kw")).sendKeys("qatest");
		Thread.sleep(2000);
		driver.quit();
	}

}
