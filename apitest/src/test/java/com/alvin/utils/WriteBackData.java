package com.alvin.utils;

public class WriteBackData {
	
	//实体类创建
	
	//回写excel sheetIndex
	private  int sheetIndex;
	// 行
	private  int rowNum;
	//列
	private  int cellNum;
	//内容
	private  String content;
	
	public int getSheetIndex() {
		return sheetIndex;
	}
	public void setSheetIndex(int sheetIndex) {
		this.sheetIndex = sheetIndex;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getCellNum() {
		return cellNum;
	}
	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public WriteBackData(int sheetIndex, int rowNum, int cellNum, String body) {
		super();
		this.sheetIndex = sheetIndex;
		this.rowNum = rowNum;
		this.cellNum = cellNum;
		this.content = body;
	}
	@Override
	public String toString() {
		return "WriteBackData [sheetIndex=" + sheetIndex + ", rowNum=" + rowNum + ", cellNum=" + cellNum + ", content="
				+ content + "]";
	}
	public WriteBackData( ) {
		super();
	}
}
