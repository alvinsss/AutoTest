
package com.alvin.businessflow;

import com.alvin.pageobject.IndexPage;
import com.alvin.pageobject.LoginPage;
import com.alvin.testdata.Constant;
import com.alvin.testdata.LoginDatas;
 
/**
* @Title: LoginFlow
* @Description: 
* @author: alvin
* @date 2022年7月29日 上午9:55:53
*/
public class LoginFlow {

 
	private String account;
	private String password;
	//对象的数据怎么进行初始化？？
	//1、有参构造
	//2、set方法
	public LoginFlow(String account, String password){
		this.account=account;
		this.password=password;
	}
	
	public LoginFlow(){
		
	}
	
	/*
	 * 登录业务流程
	 */
	public  void login(){
		LoginPage loginPage = new LoginPage();
		loginPage.inputUserAccount(account);
		loginPage.inputPassword(password);
		//验证码处理
		loginPage.clickLoginButton();
	}
	
	/*
	 * 首页退出登录的业务流程
	 */
	public void indexQuitLogin(){
		// 点击首页的退出
		IndexPage indexPage = new IndexPage();
		indexPage.buttonQuit();
	}

}
