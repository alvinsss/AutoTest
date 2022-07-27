
package com.alvin.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
* @Title: LoginTest
* @Description: 
* @author: alvin
* @date 2022年7月27日 下午2:05:06
*/
public class LoginTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.out.println("BeforeTest");
		driver=OpenBrowserDriver("chrome");
		driver.get("http://localhost/zentaopms/www/index.php");
	}

	@Test
	public void login_success() throws Exception {
		System.out.println("login_success");
		Thread.sleep(1000);
		driver.findElement(By.name("account")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("123456abcd");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		//断言1 判断url地址
//		System.out.println(driver.getCurrentUrl());
//		String expectedValue="http://localhost/zentaopms/www/index.php?m=my&f=index";
//		String actualValue=driver.getCurrentUrl();
//		Assert.assertEquals(actualValue, expectedValue);
		
		//断言2 判断登录之后是否有退出按钮
 		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		//元素可见
		WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='退出']")));
		Assert.assertTrue(webElement.isDisplayed());
		
	}

	
	@AfterTest
	public void tearDown() {
		System.out.println("@AfterTest");
	}
	/**
	 * 
	 * @param browserName
	 * @return WebDriver
	 */
	public static WebDriver OpenBrowserDriver(String browserName) {
		if ("chrome".equals(browserName)) {
			ChromeDriver driver = new ChromeDriver();
			return driver;
		} else if ("firefox".equals(browserName)) {
			System.setProperty("webdriver.firefox.bin", "D:\\UserTools\\Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			FirefoxDriver driver = new FirefoxDriver();
			return driver;

		} else if ("edge".equals(browserName)) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
			EdgeDriver driver = new EdgeDriver();
			return driver;
		}
		return null;
	}
}
