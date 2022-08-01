
package com.alvin.businessflow;

import org.testng.annotations.Test;

import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;

/**
* @Title: IndexButtonClick
* @Description: 
* @author: alvin
* @date 2022年7月29日 上午9:54:11
*/
public class IndexButtonClick {
	
	
	
	public void testClick() throws Exception {
		System.out.println("IndexButtonTest");
		IndexPage indexpage = new IndexPage();
		indexpage.buttonProduct();
		Thread.sleep(1000);
		indexpage.buttonProject();
		Thread.sleep(1000);
		indexpage.buttonQa();
		Thread.sleep(1000);
		BrowserUtil.getDriver().navigate().back();
		indexpage.buttonDoc();
		Thread.sleep(1000);
		indexpage.buttonReport();
		Thread.sleep(1000);
		indexpage.buttonHelp();
		BrowserUtil.getDriver().navigate().back();
		Thread.sleep(1000);
		BrowserUtil.getDriver().navigate().refresh();
	}
}
