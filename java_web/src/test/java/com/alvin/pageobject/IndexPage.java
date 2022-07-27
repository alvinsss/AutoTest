
package com.alvin.pageobject;
/**
* @Title: IndexPage
* @Description: 
* @author: alvin
* @date 2022年7月27日 下午5:55:01
*/

import org.openqa.selenium.By;

import com.alvin.base.BasePage;
import com.alvin.util.BrowserUtil;

public class IndexPage  extends BasePage {
	private By myQuitBy = By.xpath("//a[text()='退出']");
	 
	public void buttonQuit() {
		WaitElementClickable(myQuitBy).click();
	}
}
