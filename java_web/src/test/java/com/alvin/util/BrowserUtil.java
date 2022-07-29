
package com.alvin.util;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.alvin.base.BasePage;

/**
* @Title: BrowserUtil
* @Description: 
* @author: alvin
* @date 2022年7月27日 下午4:42:57
*/
public class BrowserUtil {
	
	private static Logger logger = Logger.getLogger(BrowserUtil.class);

	
	public static WebDriver driver;
	
	/**
	 * 工具方法一般是static
	 * @param browserName
	 * @return WebDriver
	 */
	public static void OpenBrowser(String browserName) {
		logger.info("开始测试--------");

		if ("chrome".equals(browserName)) {
			ChromeDriver chromedriver = new ChromeDriver();
			driver = chromedriver;
			logger.info("打开chrome浏览器");
		} else if ("firefox".equals(browserName)) {
			System.setProperty("webdriver.firefox.bin", "D:\\UserTools\\Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			FirefoxDriver firefoxdriver = new FirefoxDriver();
			driver = firefoxdriver;
			logger.info("打开firefox浏览器");
		} else if ("edge".equals(browserName)) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
			EdgeDriver edgedriver = new EdgeDriver();
			driver = edgedriver;
			logger.info("打开edge浏览器");
		}
	}
	
	
	/**
	 * 浏览器最大化
	 */
	public static void browserMaximize( ) {
		driver.manage().window().maximize();
	}
	
	/**
	 * 关闭浏览器
	 */
	public static void closeBrowser( ) {
		logger.info("结束测试，关闭浏览器--------");
		driver.close();;
	}
	
	
	/**
	 * 窗口切换
	 * @param driver
	 * @param title
	 */
	public static  void switchWindow(String title) {
		//Set集合是无序 不能重复 不能保证第1个数据是第一个窗口
		Set<String> handles = BrowserUtil.driver.getWindowHandles();
		for (String handle : handles) {
			if(BrowserUtil.driver.getTitle().equals(title)) {
				//退出循环
				break;
			}else {
				//不符合 我们再切换窗口句柄
				BrowserUtil.driver.switchTo().window(handle);
			}
		}
		logger.info("切换window是:"+title);
	}

}
