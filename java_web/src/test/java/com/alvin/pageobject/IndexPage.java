
package com.alvin.pageobject;
/**
* @Title: IndexPage
* @Description: 
* @author: alvin
* @date 2022年7月27日 下午5:55:01
*/

import org.openqa.selenium.By;

import com.alvin.base.BasePage;

public class IndexPage  extends BasePage {
	//退出
	private By myQuitBy = By.xpath("//a[text()='退出']");
	//我的地盘
	private By myHomeBy = By.className("active");
	//产品
	private By productBy = By.xpath("//li[@data-id='product']/a[1]");
	//项目
	private By projectBy = By.xpath("//li[@data-id='project']/a[1]");
	
	//测试
	private By qaBy = By.xpath("//li[@data-id='qa']/a[1]");
	//文档
	private By docBy = By.xpath("//li[@data-id='doc']/a[1]");
	//统计
	private By reportBy = By.xpath("//li[@data-id='report']/a[1]");
	//组织
	private By companyBy = By.xpath("//li[@data-id='company']/a[1]");
	//后台
	private By backadminBy = By.xpath("//li[@data-id='admin']/a[1]");
	//帮助
	private By helpBy = By.className("dropdown");
	//手册
	private By helpSCBy = By.xpath("//a[text()='手册']");
	//关于
	private By AboutBy = By.xpath("//a[text()='关于']");
	

	
	//*[@class='active' and text()='项目']
	public void buttonQuit() {
//		WaitElementClickable(myQuitBy).click();
		click(myQuitBy);
	}
	
	public void buttonMyHome() {
		click(myHomeBy);
	}
	public void buttonProduct() {
		click(productBy);
	}
	public void buttonProject() {
		click(projectBy);
	}
	public void buttonQa() {
		click(qaBy);
	}
	public void buttonDoc() {
		click(docBy);
	}
	public void buttonReport() {
		click(reportBy);
	}
	public void buttonCompany() {
		click(companyBy);
	}
	public void buttonBackadmin() {
		click(backadminBy);
	}
	
	public void buttonHelp() {
		click(helpBy);
	}
	
	public void buttonHelpSC() {
		click(helpSCBy);
	}
	public void buttonAbout() {
		click(AboutBy);
	}
 
	public boolean isDisplayed_ButtonQuit() {
		return WaitElementVisible(myQuitBy).isDisplayed();
	}
}
