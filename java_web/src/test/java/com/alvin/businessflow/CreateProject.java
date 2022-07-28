
package com.alvin.businessflow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.pageobject.ProjectPage;
import com.alvin.testcases.LoginTest;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;
import com.alvin.util.Constant;

/**
* @Title: CreateProject
* @Description: 
* @author: alvin
* @date 2022年7月28日 下午12:07:20
*/
public class CreateProject {
	
	@Parameters({"browerName"})
	@BeforeTest
	public void setUp(String browerName) {
		BrowserUtil.OpenBrowser(browerName);
		BrowserUtil.driver.get(Constant.LOGIN_URL);
		BrowserUtil.driver.manage().window().maximize();
	}
	
	@Test
	public void test_createProject() throws Exception {
		
		System.out.println("test_createProject");
		String projectName = "web自动化"+System.currentTimeMillis();
		String projectModuleName = "web自动化"+(int)Math.ceil(Math.random() * 100);
		String projectCode = "web自动化Code"+System.currentTimeMillis();
		String projectDescribe = "web自动化描述";

		LoginPage loginPage = new LoginPage();
		loginPage.inputUserAccount(LoginDatas.CORRECT_ACCOUNT);
		loginPage.inputPassword(LoginDatas.CORRECT_PASSWORD);
		loginPage.clickLoginButton();
		Thread.sleep(1000);
		
		IndexPage indexPage = new IndexPage();
		indexPage.buttonProject();


		System.out.println("projectName:"+projectName);
		ProjectPage projectPage = new ProjectPage();
		//点击创建项目按钮
		projectPage.click_CreateProject();
		//创建页面输入
		projectPage.input_ProjectName(projectName);
		projectPage.input_ProjectCode(projectName);
		projectPage.clcik_ProjectEndRadio();
		projectPage.click_SaveProject();
		Thread.sleep(2000);
		projectPage.click_ProjectTipsClose();
		Thread.sleep(6000);

		
		//维护模块
		projectPage.clcik_ProjectDetailModuleUpdata();
		Thread.sleep(1000);
		projectPage.input_ProjectDetailModuleUpdata_Name(projectName);
		Thread.sleep(1000);
		projectPage.click_ProjectDetailModuleUpdataSave();
		//返回
		Thread.sleep(4000);
		projectPage.click_ProjectDetailModuleUpdataBack();
		
		//编辑项目
		Thread.sleep(1000);
//		System.out.println(BrowserUtil.driver.getPageSource());
		projectPage.clcik_ProjectDetailEdit();
		projectPage.input_ProjectDetailEdit_Code(projectCode);
		System.out.println(BrowserUtil.driver.getCurrentUrl());
//		projectPage.input_ProjectDetailEdit_Describe(projectDescribe);
		projectPage.click_SaveProject();
		Thread.sleep(2000);

		
		
	}
	
	@AfterTest
	public void tearDown() {
		BrowserUtil.driver.quit();
	}
	

}
