# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 11:04
# @Author  : alvin
# @File    : handle_excel_v1.py
# @Software: PyCharm
'''
函数：get_excel_data()
版本： v2.0
函数功能：1.获取请求的body 与预期响应结果
        2.可以自定义获取对应的列数据
具体：方案1：直接使用列编号
     方案2：增加代码可读取性使用 列名去操作
'''
import xlrd

def get_excel_data(excelDir,sheetName,caseName=None,*colName):
    resList=[]
    #加载文件,formatting_info保持样式
    workBook = xlrd.open_workbook(excelDir,formatting_info=True)
    workSheets = workBook.sheet_names()#sheet所有名
    #2获取对应的表
    workSheet= workBook.sheet_by_name(sheetName)
    '''
        把用户传入的colname转化成操作xls的编号
    '''
    colIndxList= []
    for i in colName:
                                                # xls的编号
        colIndxList.append(workSheet.row_values(0).index(i))

    idx = 0 #行号初始
    for data in workSheet.col_values(0):
        if caseName in data:
            # print(caseName)
            getColData = []#存放一行对应很多列数据
            for colIdx in colIndxList:
                res = workSheet.cell_value(idx,colIdx)#单元格数据
                getColData.append(res)
            resList.append(getColData)
        idx = idx +1
    return resList

if __name__ == '__main__':
    configData = ['标题','URL']
    res=get_excel_data('../data/alist_System_V1.5.xls','登录模块','Login',*configData)
    print(res)
    for one in res:
        print(one)

