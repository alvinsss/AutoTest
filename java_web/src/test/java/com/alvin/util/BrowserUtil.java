
package com.alvin.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
* @Title: BrowserUtil
* @Description: 
* @author: alvin
* @date 2022年7月27日 下午4:42:57
*/
public class BrowserUtil {
	
	
	/**
	 * 工具方法一般是static
	 * @param browserName
	 * @return WebDriver
	 */
	public static WebDriver OpenBrowser(String browserName) {
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
