
package com.alvin.util;

import java.util.Set;

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
	
	public static WebDriver driver;
	
	/**
	 * 工具方法一般是static
	 * @param browserName
	 * @return WebDriver
	 */
	public static void OpenBrowser(String browserName) {
		if ("chrome".equals(browserName)) {
			ChromeDriver chromedriver = new ChromeDriver();
			driver = chromedriver;
		} else if ("firefox".equals(browserName)) {
			System.setProperty("webdriver.firefox.bin", "D:\\UserTools\\Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			FirefoxDriver firefoxdriver = new FirefoxDriver();
			driver = firefoxdriver;

		} else if ("edge".equals(browserName)) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
			EdgeDriver edgedriver = new EdgeDriver();
			driver = edgedriver;
		}
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
