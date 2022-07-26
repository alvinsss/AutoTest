
package com.alvin;

import java.util.Set;

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
		
		public static  void switchWindow(WebDriver driver,String title) {
			//Set集合是无序 不能重复 不能保证第1个数据是第一个窗口
			Set<String> handles = driver.getWindowHandles();
			System.out.println(handles);
			System.out.println(driver.getTitle());
			for (String handle : handles) {
				if(driver.getTitle().equals(title)) {
					//退出循环
					break;
				}else {
					//不符合 我们再切换窗口句柄
					driver.switchTo().window(handle);
				}
			}
			System.out.println(driver.getTitle());
		}
}
