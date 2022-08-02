
package com.alvin.testdata;

import org.testng.annotations.DataProvider;

/**
* @Title: LoginDatas
* @Description: 
* @author: alvin
* @date 2022年7月28日 上午9:40:29
*/
public class LoginDatas {
	
	//正确的账号
	public static final String CORRECT_ACCOUNT="admin";
	//正确的密码
	public static final String CORRECT_PASSWORD="123456abcd";
	
	@DataProvider
	public static Object[][] getLoginFailureDatas(){
		Object[][] datas = {
				{"admin","123456abc","登录失败，请检查您的用户名或密码是否填写正确。"},
				{"","123456abcd","登录失败，请检查您的用户名或密码是否填写正确。"} 
	 };		 
		return datas;
	}
	
	@DataProvider
	public static Object[][] getLoginErrorDatas(){
		Object[][] datas = {
				{"alvin","123456abc","登录失败，请检查您的用户名或密码是否填写正确1。"}  };
		return datas;
	}

}
