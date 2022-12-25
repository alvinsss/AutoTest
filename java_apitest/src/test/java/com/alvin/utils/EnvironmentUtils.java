package com.alvin.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 模拟环境变量
 * @author:alvin
 *
 */
public class EnvironmentUtils {
	
	//局部变量尽量接口类型 
	public static Map<String, String>  env = new HashMap<String, String>();
	
	
	public static String getRegisterPhone() {
		Integer headRandom = new Random().nextInt(25);
		String mobile = getHeadMobile(headRandom) + getEndMobile();
		return mobile;
	}

	private static String getHeadMobile(Integer type) {
		switch (type) {
		case 1:
			return "130";
		case 2:
			return "131";
		case 3:
			return "132";
		case 4:
			return "133";
		case 5:
			return "134";
		case 6:
			return "135";
		case 7:
			return "136";
		case 8:
			return "137";
		case 9:
			return "138";
		case 10:
			return "139";
		case 11:
			return "150";
		case 12:
			return "151";
		case 13:
			return "152";
		case 14:
			return "153";
		case 15:
			return "155";
		case 16:
			return "156";
		case 17:
			return "157";
		case 18:
			return "158";
		case 19:
			return "159";
		case 20:
			return "177";
		case 21:
			return "186";
		case 22:
			return "183";
		case 23:
			return "187";
		case 24:
			return "188";
		case 25:
			return "189";
		default:
			return "173";
		}
	}

	/**
	 * 获取尾号4位
	 * 
	 * @return
	 */
	private static String getEndMobile() {
		String ychar = "0,1,2,3,4,5,6,7,8,9";
		int wei = 8;
		String[] ychars = ychar.split(",");
		String endMobile = "";
		Random rdm = new Random();
		for (int i = 0; i < wei; i++) {
			int j = (rdm.nextInt() >>> 1) % 10;
			if (j > 10)
				j = 0;
			endMobile = endMobile + ychars[j];
		}
		return endMobile;
	}
}
