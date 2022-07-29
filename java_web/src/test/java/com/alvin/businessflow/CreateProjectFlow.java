
package com.alvin.businessflow;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.pageobject.ProjectPage;
import com.alvin.testcases.LoginTest;
import com.alvin.testdata.Constant;
import com.alvin.testdata.LoginDatas;
import com.alvin.util.BrowserUtil;

/**
* @Title: CreateProject
* @Description: 
* @author: alvin
* @date 2022年7月28日 下午12:07:20
*/
public class CreateProjectFlow {
	
	public static String projectNamePrefix ="web自动化";
	public static String projectName = projectNamePrefix +System.currentTimeMillis(); 

	private static ProjectPage projectPage = new ProjectPage();

	public CreateProjectFlow(String projectNamePrefix ){
		this.projectNamePrefix=projectNamePrefix;
		System.out.println("projectNamePrefix-->"+projectNamePrefix);
		System.out.println("projectName-->"+projectName);
	}
	
	//点击创建项目
	public void click_projectCreateLink() throws Exception {
		projectPage.click_CreateProject();
	}
	
	/**
	 * 输入项目数据
	 * @throws Exception
	 */
	public void input_projectData() throws Exception {
		System.out.println("input_projectData");

		//输入数据
		projectPage.input_ProjectName(projectName);
		projectPage.input_ProjectCode(projectName);
		projectPage.clcik_ProjectEndRadio();
		projectPage.click_SaveProject();
		Thread.sleep(2000);
		projectPage.click_ProjectTipsClose();
		Thread.sleep(6000);
	}
	
	
	
	/**
	 * 维护模块
	 * @throws Exception
	 */
	public void input_moduleUpdataProject() throws Exception {
		
		ProjectPage projectPage = new ProjectPage();
		//维护模块
		projectPage.clcik_ProjectDetailModuleUpdata();
		Thread.sleep(1000);
		projectPage.input_ProjectDetailModuleUpdata_Name(projectName);
		Thread.sleep(1000);
		projectPage.click_ProjectDetailModuleUpdataSave();
		//返回
		Thread.sleep(4000);
		projectPage.click_ProjectDetailModuleUpdataBack();
	}
	
	
	
	/**
	 * 编辑项目
	 * @throws Exception
	 */
	public void input_editProject() throws Exception {
		
		String projectCode = projectNamePrefix+"Code"+(int)Math.ceil(Math.random() * 100);
//		ProjectPage projectPage = new ProjectPage();
		//编辑项目
		Thread.sleep(1000);
		projectPage.clcik_ProjectDetailEdit();
		projectPage.input_ProjectDetailEdit_Code(projectName);
//		projectPage.input_ProjectDetailEdit_Describe(projectDescribe);
		projectPage.click_SaveProject();
		Thread.sleep(2000);
	}
	

	
	//获取自动化代码创建的项目名称
	public String get_autoTestcurrentProjectNameText()  {
		return projectPage.get_currentProjectNameText();
	}
	
	//获取输入的项目名称
	public String get_inputCreateProjectName()  {
		return this.projectName;
	}
	
	
}
