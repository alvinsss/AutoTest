
package com.alvin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.businessflow.CreateProjectFlow;
import com.alvin.businessflow.LoginFlow;
import com.alvin.pageobject.IndexPage;
import com.alvin.testdata.Constant;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;

/**
* @Title: CreateProjectTest
* @Description: 
* @author: alvin
* @date 2022年7月29日 上午11:30:35
*/
public class CreateProjectTest {
	
	@Parameters({"browerName"})
	@BeforeMethod
	public void setUp(String browerName) {
		BrowserUtil.OpenBrowser(browerName);
		BrowserUtil.driver.get(Constant.LOGIN_URL);
		BrowserUtil.driver.manage().window().maximize();
	}
	
	@Test
	public void createProjectTest() throws Exception {
		
		//登录
		Thread.sleep(1000);
		LoginFlow loginFlow = new LoginFlow(LoginDatas.CORRECT_ACCOUNT,LoginDatas.CORRECT_PASSWORD);
		loginFlow.login();
		Thread.sleep(1000);
		
		//点击创建项目按钮
		System.out.println("createProjectTest 点击创建项目按钮");
		IndexPage indexPage = new IndexPage();
		indexPage.buttonProject();
		Thread.sleep(1000);

 
		CreateProjectFlow createProject = new CreateProjectFlow("Web自动化");
		//点击创建项目链接
		createProject.click_projectCreateLink();
		//输入项目数据
		createProject.input_projectData();
		System.out.println("createProjectTest模块维护");
		createProject.input_moduleUpdataProject();
		System.out.println("createProjectTest 编辑项目");
		createProject.input_editProject();
		System.out.println(BrowserUtil.driver.getCurrentUrl());
		Thread.sleep(2000);
		String get_inputCreateProjectName = createProject.get_inputCreateProjectName();
		String get_currentProjectNameText = createProject.get_autoTestcurrentProjectNameText();

		Assert.assertEquals(get_inputCreateProjectName, get_currentProjectNameText);
	}
	
	@AfterMethod
	public void tearDown() {
		BrowserUtil.closeBrowser();
	}
	
}
