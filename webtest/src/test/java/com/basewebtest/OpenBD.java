
package com.basewebtest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
* @Title: OpenBD
* @Description: 
* @author: alvin
* @date 2022年7月25日 下午7:31:12
*/
public class OpenBD {
	public static void main(String[] args) {
//		ChromeDriver driver = new ChromeDriver();
//		driver.get("http://www.baidu.com");
		
//		System.setProperty("webdriver.firefox.bin","D:\\UserTools\\Firefox\\firefox.exe");
//		System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
//		FirefoxDriver driver = new FirefoxDriver();
//		driver.get("http://www.baidu.com");
		
		System.setProperty("webdriver.edge.driver","src/test/resources/msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://www.baidu.com");
		
	}
}
