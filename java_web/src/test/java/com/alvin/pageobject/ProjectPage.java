
package com.alvin.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.alvin.base.BasePage;
import com.alvin.util.BrowserUtil;

/**
* @Title: ProjectPage
* @Description: 
* @author: alvin
* @date 2022年7月28日 下午3:52:11
*/
public class ProjectPage extends BasePage{
	//创建项目
	private By createProjectBy = By.xpath("//*[@id='modulemenu']/ul[1]/li[@data-id='create']/a[1]/i[1]");
	//项目名称	
	private By projectNameBy = By.id("name");
	//项目代号	
	private By projectCodeBy = By.id("code");
	//项目描述
	private By projectDescribeBy = By.xpath("//th[text()='项目描述']");
	//项目结束日期
	private By projectEndDateBy = By.id("end");
	//项目结束单选一年
	private By projectEndRadioBy = By.id("delta365");
	//项目保存
	private By projectSaveBy = By.xpath("//*[@id='submit']");
	//关闭提示
	private By projectTipsCloseBy = By.xpath("//*[@id='tipsModal']/div[1]/a[1]");
	
	
	//编辑
	private By projectDetail_EditBy = By.xpath("//a[text()='编辑']");
	//删除
	private By projectDetail_DelBy = By.xpath("//a[text()='删除']");
	//维护模块
	private By projectDetail_ModuleUpdataBy = By.xpath("//a[text()='维护模块']");
	//列表页是否显示模块名
	private By projectDetail_is_DisplayBy = By.xpath("//a[text()='列表页是否显示模块名']");
	
	
	//维护模块
	private By projectDetail_ModuleUpdataNameBy = By.xpath("//*[@class='panel-body']/table[@class='table table-form']/tbody[1]/tr[1]/td[@id='moduleBox']/div[1]/div[1]/div[1]/input[@type='text']");
	//维护模块-保存
	private By projectDetail_ModuleUpdataSaveBy = By.xpath("//*[@id='submit']");
	//维护模块-返回
	private By projectDetail_ModuleUpdataBackBy = By.xpath("//button[text()='返回']");	
	
	public void click_CreateProject() {
		click(createProjectBy);
	}
	
	public void input_ProjectName(String projectName) {
		input_type(projectNameBy, projectName);
	}
	public void input_ProjectCode(String projectCode) {
		input_type(projectCodeBy, projectCode);
	}
	public void input_ProjectEndDate(String projectEndDate) {
		input_type(projectEndDateBy, projectEndDate);
	}
	public void clcik_ProjectEndRadio() {
		click(projectEndRadioBy);
	}
	
	//保存按钮非首屏 需要js滚动展示
	public void click_SaveProject( ) {
		JavascriptExecutor JSExecutor = (JavascriptExecutor)BrowserUtil.driver;
		JSExecutor.executeScript("document.getElementById('submit').scrollIntoView()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(projectSaveBy);
	}
	//添加成功之后的关闭对话框
	public void click_ProjectTipsClose( ) {
		click(projectTipsCloseBy);
	}
	
	// 项目详情 模块维护
	public void clcik_ProjectDetailModuleUpdata() {
		click(projectDetail_ModuleUpdataBy);
	}
	//项目详情 模块维护输入模块名称
	public void input_ProjectDetailModuleUpdata_Name(String projectModuleUpdata_Name) {
		input_type(projectDetail_ModuleUpdataNameBy, projectModuleUpdata_Name);
	}
	
	// 项目详情 模块维护保存
	public void click_ProjectDetailModuleUpdataSave( ) {
		click(projectDetail_ModuleUpdataSaveBy);
	}
	// 项目详情 模块维护返回
	public void click_ProjectDetailModuleUpdataBack( ) {
		click(projectDetail_ModuleUpdataBackBy);
	}
	

	
	// 项目详情 -- 编辑
	public void clcik_ProjectDetailEdit() {
		click(projectDetail_EditBy);
	}
	
	// 项目详情 编辑->项目代号 
	public void input_ProjectDetailEdit_Code(String projectCode) {
		input_type(projectCodeBy,projectCode);
	}
	// 项目详情 编辑->描述
	public void input_ProjectDetailEdit_Describe(String projectDescribe) {
		try {
			System.out.println("input_ProjectDetailEdit_Describe");
			JavascriptExecutor JSExecutor = (JavascriptExecutor)BrowserUtil.driver;
			JSExecutor.executeScript("document.getElementById('submit').scrollIntoView()");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input_type(projectDescribeBy,projectDescribe);
	}
	
}
