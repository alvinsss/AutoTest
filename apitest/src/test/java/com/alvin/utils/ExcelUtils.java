package com.alvin.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;


import com.alvin.pojo.API;
import com.alvin.pojo.Case;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

public class ExcelUtils {

	public static void main(String[] args) throws Exception {

//		Object[][] datas = read_v1();
//		for (Object[] objects : datas) {
//			System.out.println(Arrays.toString(objects));
//		}
		
		List<API> excelData = getExcelData(0, 1, API.class);
		for (API api : excelData) {
			System.out.println(api);
		}
		
	}
	/**
	 * getCase和getAPI 方法抽取 ，使用泛型代替和返回list
	 * @param <T>
	 * @param setStartSheetIndex
	 * @param setSheetNum
	 * @param clazz
	 * @return
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	private static<T> List<T> getExcelData(int setStartSheetIndex,int setSheetNum,Class<T> clazz) throws FileNotFoundException, Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/cases_v3.xlsx");
		//导入参数设置类
		ImportParams params = new ImportParams();
		params.setStartSheetIndex(setStartSheetIndex);
		params.setSheetNum(setSheetNum);
		//导入验证
		List<T> importExcelList = ExcelImportUtil.importExcel(fis, clazz, params);
		return importExcelList;
	}
	
	private static void getCase() throws FileNotFoundException, Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/cases_v3.xlsx");
		//导入参数设置类
		ImportParams params = new ImportParams();
		params.setStartSheetIndex(1);
		params.setSheetNum(0);
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
		params.setSheetNum(1);

		//导入验证
//		params.setNeedVerify(true);
		List<API> importExcel = ExcelImportUtil.importExcel(fis, API.class, params);
		for (API api : importExcel) {
			System.out.println(api);
		}
	}
	
//		poi
		public static Object[][] read_v1() throws IOException  {
	//      1.打开文件excel （流读）
			FileInputStream fis = new FileInputStream("src/test/resources/cases_v1.xls");
	//		2.创建excel对象workbook
			Workbook workbook = WorkbookFactory.create(fis);
	//		3.获取sheet表单
			Sheet sheet = workbook.getSheetAt(0);
	//		4.1 获取最大行号,从0开始
			int lastRowNum = sheet.getLastRowNum();
			Object[][] datas = new Object[lastRowNum][4];
	//		System.out.println("获取最大行号:"+lastRowNum);
			//4.2循环所有的行
			for (int i=1;i<=lastRowNum;i++ ) {
				// 4.3 获取当前行
				Row row = sheet.getRow(i);
				//4.4获取最大的列号
				 int lastCellNum = row.getLastCellNum();
	//				System.out.println("获取最大列号:"+lastCellNum);
				 //4.5遍历所有单元格
				for (int j=0,index=0;j<lastCellNum;j++) {
					//对应第几列数据
					if (j==2 || j==3 || j==5|j==6) {
	//					5.获取Cell（单元格）
						Cell cell = row.getCell(j,MissingCellPolicy.CREATE_NULL_AS_BLANK);
	//					5.1 获取单元格的内容
						String stringCellValue = cell.getStringCellValue();
//						System.out.println(stringCellValue+",");
						datas[i-1][index++] = stringCellValue;
					}
	
				}
//				System.out.println();
				
			}
			//6关闭流
			fis.close();
			return datas;
		}
	
}
