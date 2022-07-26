
package com.alvin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
* @Title: OpenBrowser
* @Description: 
* @author: alvin
* @date 2022年7月26日 下午5:47:35
*/
public class OpenBrowser {
	/***
	 * //ChromeDriver \ FirefoxDriver\ InternetExplorerDriver继承于WebDriver 
	 *  多态：使用父类类型接受子类对象
	 * @param  browserName浏览器名字
	 * @return WebDriver父类类型
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
