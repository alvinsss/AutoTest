
package com.alvin.testdemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
		
		//4.iframe
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
		
//		5. window 
//		driver.get("https://www.baidu.com/");
//		driver.findElement(By.xpath("//a[text()='新闻']")).click();
//		System.out.println(driver.getTitle());
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='hao123']")).click();
//		System.out.println(driver.getTitle());
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='视频']")).click();
//		System.out.println(driver.getTitle());
//		Thread.sleep(2000);
//		OpenBrowser.switchWindow(driver,"百度新闻——海量中文资讯平台");
		
//		6.radio 单选框
//		driver.get("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\单选多选框\\radio.html");
//		//根据value使用xpath匹配
//		WebElement element = driver.findElement(By.xpath("//input[@value='female']"));
//		element.click();
//		//输出是否选中状态
//		System.out.println(element.isSelected());
		
//		7.checkbox多选框
//		driver.get("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\单选多选框\\checkbox.html");
//		//根据value使用xpath匹配
//		driver.findElement(By.xpath("//input[@value='Math']")).click();
//		driver.findElement(By.xpath("//input[@value='English']")).click();
//		//输出是否选中状态
//		System.out.println(driver.findElement(By.xpath("//input[@value='English']")).isSelected());
	
	    
//		8.下拉框
//		driver.get("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\单选多选框\\select.html");
//		WebElement element = driver.findElement(By.id("abc"));
		// select 元素包装成select对象
//		Select select = new Select(element);
//		select.selectByIndex(1);
		//根据value属性选择的
//		select.selectByValue("英文");
//		select.selectByVisibleText("历史");
		
//		9.时间控件，通过JavaScript去掉属性readonly
//		driver.get("https://www.12306.cn/index/index.html");
//
//		//多层继承接口JavascriptExecutor进行强制转换
//		JavascriptExecutor JSExecutor = (JavascriptExecutor)driver;
//		WebElement element = driver.findElement(By.id("train_date"));
//		//添加readOnly属性
//		JSExecutor.executeScript("document.getElementById('train_date').readOnly= true");
//		System.out.println(element.getAttribute("readOnly"));
//		Thread.sleep(1000);
////		移除readOnly属性
//		JSExecutor.executeScript("document.getElementById('train_date').removeAttribute('readonly')");
//		//判断是否移除成功，如果成功等于null
//		if (element.getAttribute("readOnly") == null) {
//			element.clear();
//			element.sendKeys("2023-02-12");
//		}
//		Thread.sleep(3000);
//		//通过js完成页面滚动到指定元素位置-最新发布
////		JSExecutor.executeScript("document.getElementById('index_ads').scrollIntoView()");
//		//arguments[0]接收elementIndex_ads,executeScript支持传引用和基本数据类型
//		WebElement elementIndex_ads = driver.findElement(By.id("index_ads"));
//		JSExecutor.executeScript("arguments[0].scrollIntoView()",elementIndex_ads);
//		int i=0;
//		JSExecutor.executeScript("arguments[0].scrollIntoView(arguments[1])",elementIndex_ads,i);

//		懒加载：https://sj.qq.com/myapp/category.htm?orgame=1&categoryId=122
		//懒加载 --页面比较复杂-->需要时间加载
		/*driver.get("https://sj.qq.com/myapp/category.htm?orgame=1&categoryId=122");
		//拼多多
		//driver.findElement(By.xpath("//a[text()='拼多多']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[text()='粉丝福利购']")).click();
		//问题？？要滑动到什么位置 -- 正在加载中元素的位置
		//怎么针对页面中一闪而过的元素进行定位
		//1、开启F12 ，选择network->slow 3G 网速放慢点
		//2、F12--》选择source-->选择暂停
		////div[@class='loading']
		WebElement webElement = driver.findElement(By.xpath("//div[@class='loading']"));
		JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
		//可能会存在这几种情况
		//1、默认就有这个元素  --OK
		//2、滑动了几次之后可以找的到元素  --OK
		//3、滑动到底部还是找不到元素  --OK
		
		while(true){	
			//滑动之前的页面信息
			String beforeSource = driver.getPageSource();
			//如果找到了元素，我们就退出
			if(beforeSource.contains("拼XX")){
				driver.findElement(By.xpath("//a[text()='拼XX']")).click();
				break;
			}
			
			//滑动到指定元素的位置上
			jsExecuter.executeScript("arguments[0].scrollIntoView()",webElement);
			Thread.sleep(1000);
			String afterSource = driver.getPageSource();
			//是不是滑动到了底部  getPageSource()  滑动之前的PageSource和滑动之后的PageSource是一样
			if(beforeSource.equals(afterSource)){
				//滑动到了底部
				break;
			}
		}
		
		//driver.findElement(By.xpath("//a[text()='粉丝福利购']")).click();
		 * */
		
//		driver.get("https://open.tencent.com/");
//
//		//多层继承接口JavascriptExecutor进行强制转换
//		JavascriptExecutor JSExecutor = (JavascriptExecutor)driver;
//		WebElement elementIndex_QQ = driver.findElement(By.xpath("//div[@class='title' and text()='QQ推广' ]"));
//		Thread.sleep(1000);
//		JSExecutor.executeScript("arguments[0].scrollIntoView()",elementIndex_QQ);
//		System.out.println(elementIndex_QQ.getText());
//		Thread.sleep(1000);
		
		//鼠标拖拽
//		driver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
//		Thread.sleep(2000);
//		WebElement sourceEle = driver.findElement(By.id("treeDemo_2_span"));
//		WebElement targetEle = driver.findElement(By.id("treeDemo_3_span"));
//		实例化Actions类对象
//		Actions actions = new Actions(driver); 
		//clickAndHold一直按鼠标       moveToElement移动到   release释放鼠标
		// build构建一连串操作 perform立马生效
//		actions.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
		
		//文件上传  <input type="file" id="fu" value="选择文件">
		driver.get("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\文件上传\\fileupload.html");
		Thread.sleep(2000);
		driver.findElement(By.id("fu")).sendKeys("E:\\eclipse-workspace\\JavaAutoTest\\java_web\\src\\test\\resources\\html\\文件上传\\uploadfile.png");

		
	}
}
