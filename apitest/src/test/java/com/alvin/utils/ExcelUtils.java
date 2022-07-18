package com.alvin.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public static void main(String[] args) throws Exception, IOException, Exception {
		Object[][] datas =read();
		for (Object[] objects : datas) {
			System.out.println(Arrays.toString(objects));
		}
	}
	
	public static Object[][] read() throws IOException, Exception, InvalidFormatException {
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
					cell.setCellType(CellType.STRING);
//					5.1 获取单元格的内容
					String stringCellValue = cell.getStringCellValue();
//					System.out.println(stringCellValue+",");
					datas[i-1][index++] = stringCellValue;
				}

			}
//			System.out.println();
			
		}
		//6关闭流
		fis.close();
		return datas;
	}

}
