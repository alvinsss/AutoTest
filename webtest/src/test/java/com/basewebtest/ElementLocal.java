
package com.basewebtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
* @Title: ElementLocal
* @Description: 
* @author: alvin
* @date 2022年7月26日 上午10:22:10
*/
public class ElementLocal {
	
	
	public static void main(String[] args) {
		
		WebDriver driver = OpenBD.OpenBrowser("firefox");
		driver.get("http://www.baidu.com");
//		driver.findElement(By.id("kw")).sendKeys("qatest");
//		driver.findElement(By.name("wd")).sendKeys("qatest");
		// tagName 可能不是唯一的 
//		List<WebElement> list = driver.findElements(By.tagName("input"));
//		System.out.println(list.size());
//		List<WebElement> list2 = driver.findElements(By.id("kw"));
//		System.out.println(list2.size());
		//className
//		driver.findElement(By.className("s_ipt")).sendKeys("qatest");
		//Compound class names not permitted,className多个类名不可以，解决选择全局唯一定位
//		driver.findElement(By.className("s_btn")).click();
//		driver.findElement(By.linkText("新闻")).click();
//		driver.findElement(By.partialLinkText("闻")).click();
		
		//cssSeletor By.tagName
		List<WebElement> list3 = driver.findElements(By.cssSelector("input"));
		System.out.println(list3.size());
		
		//cssSeletor By.id
//		driver.findElement(By.cssSelector("#kw")).sendKeys("test");
//		driver.findElement(By.cssSelector("input#kw")).sendKeys("test1");
		//cssSeletor By.className
//		driver.findElement(By.cssSelector(".s_ipt")).sendKeys("test2");
		//cssSeletor 支持复合类名 写的时候每个类名前面都需要加.
//		driver.findElement(By.cssSelector(".bg.s_btn")).click();
//		cssSeletor 高级定位  标签名[属性名='属性值']
//		driver.findElement(By.cssSelector("input[autocomplete='off']")).sendKeys("test3");
	//		多属性组合定位  标签名[属性名1='属性值1'] 标签名[属性名2='属性值2']		
//		driver.findElement(By.cssSelector("input[name='wd'][maxlength='255'][autocomplete='off']")).sendKeys("test4");

//		xpath 单属性选择//*[@属性名=属性值] 多属性选择 //*[@属性名1=属性值1 and @属性名2=属性值2] 
		//支持元素全部文本的定位  //*[text()='文本值']  
		//支持部分属性/文本的定位  //*[contains(@name,'wd')]    //*[contains(text(),'登录')]  
		driver.findElement(By.xpath("//*[contains(@name,'wd')] ")).sendKeys("qa");
	}

}
