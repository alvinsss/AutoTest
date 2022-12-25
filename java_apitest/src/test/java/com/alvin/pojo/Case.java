package com.alvin.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Case {
	// 用例编号
	@Excel(name = "用例编号")
	private int id;
	// 用例描述
	@Excel(name = "用例描述")
	private String desc;
	// 参数
	@Excel(name = "参数")
	private String params;
	// 接口编号
	@Excel(name = "接口编号")
	private String apiId;
	// 期望响应数据
	@Excel(name = "期望响应数据")
	private String expect;
	
	// 检验SQL
	@Excel(name = "检验SQL")
	private String sql;

	public Case() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Case(int id, String desc, String params, String apiId, String expect, String sql) {
		super();
		this.id = id;
		this.desc = desc;
		this.params = params;
		this.apiId = apiId;
		this.expect = expect;
		this.sql = sql;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	

}
