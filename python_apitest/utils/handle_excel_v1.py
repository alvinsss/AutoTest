# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 11:04
# @Author  : alvin
# @File    : handle_excel_v1.py
# @Software: PyCharm
'''
函数：get_excel_data()
版本： v1.0
函数功能：获取请求的body 与预期响应结果
具体：1-导入excel读取库 xlrd 处理xls格式 ，openpyxl 出来xlxs
     2-把excel文件读取到内存，excel对象
     3-找到需要操作的sheet
     4-获取对应的行与列数据（单元格数据）
'''
import xlrd

def get_excel_data(excelDir,sheetName,caseName=None):
    resList=[]
    #加载文件,formatting_info保持样式
    workBook = xlrd.open_workbook(excelDir,formatting_info=True)
    workSheets = workBook.sheet_names()#sheet名
    #2获取对应的表
    workSheet= workBook.sheet_by_name(sheetName)
    #3获取数据
    # print(workSheet.row_values(0))#获取0行
    # print(workSheet.col_values(0))#获取第0列
    # print(workSheet.cell_value(1,5))#获取一个单元格数据 行，列
    idx = 0 #行号初始
    for data in workSheet.col_values(0):
        if caseName in data:
            # print(caseName)
            reqBody = workSheet.cell_value(idx,9)
            respData = workSheet.cell_value(idx,11)
            resList.append((reqBody,respData))
        idx = idx +1
    return resList

if __name__ == '__main__':
    res=get_excel_data('../data/alist_System_V1.5.xls','登录模块','Login')
    print(res)
    for one in res:
        print(one)

