package com.alvin.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import com.alvin.pojo.API;
import com.alvin.pojo.Case;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

public class ExcelUtils {

	public static void main(String[] args) throws Exception {
		getAPI();
//		getCase();
	}
	
	private static void getCase() throws FileNotFoundException, Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/cases_v3.xlsx");
		//导入参数设置类
		ImportParams params = new ImportParams();
		params.setStartSheetIndex(1);
		//导入验证
//		params.setNeedVerify(true);
		List<Case> importExcel = ExcelImportUtil.importExcel(fis, Case.class, params);
		for (Case c : importExcel) {
			System.out.println(c);
		}
	}

	private static void getAPI() throws FileNotFoundException, Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/cases_v3.xlsx");
		//导入参数设置类
		ImportParams params = new ImportParams();
		params.setStartSheetIndex(0);
		//导入验证
//		params.setNeedVerify(true);
		List<API> importExcel = ExcelImportUtil.importExcel(fis, API.class, params);
		for (API api : importExcel) {
			System.out.println(api);
		}
	}
	
}
