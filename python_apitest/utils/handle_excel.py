# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 11:04
# @Author  : alvin
# @File    : handle_excel_v4.py
# @Software: PyCharm
print()
"""
---------------版本 v3.0---------------
需求：
    1- 需要对测试用例进行挑选
        全部：1，2，3，4，5
        挑选出：优先级高/特定用例bug回归
分析需求：
    用例挑选的方式：
        1- 全部 all
        2- 只选择某一个用例  tc001
        3- 连续的用例  tc003-tc005
        4- 复合型  ['tc003','tc007-tc009','tc010']
解决方案：

测试反馈：
    函数调用的参数传递的太多！
        get_excel_data(fileDir,'登录模块','Login','URL','标题','前置条件')
版本迭代建议：

"""
"""
---------------版本 v4.0---------------
需求：
    函数调用的参数传递的太多！
        get_excel_data(fileDir,'登录模块','Login','URL','标题','前置条件')
分析需求：
    配置文件出去
        ini
        yaml
解决方案：
    尽可能使用代码去识别获取！

测试反馈：
版本迭代建议：
"""
import xlrd #pip  install  xlrd
from python_apitest.utils.handle_path import testData_path
import os

print()

def get_excel_data(sheetName,caseName,*args,runCase=['all'],excelDir=None): # 返回值是列表    -> list    def get_excel_data() -> list
    """
    :param sheetName: 选择的sheet表
    :param caseName: 用例名
    :param args: 获取的数据
    :param runCase: 筛选的用例
    :param excelDir: 用例文件路径
    :return: [(),()]
    """
    excelDir = os.path.join(testData_path,'alist_System_V1.5.xls')
    resList = []#存放结果
    #1- 打开一个文件:
    #formatting_info=True 保持原样式
    workBook = xlrd.open_workbook(excelDir,formatting_info=True)#excel文件
    # sheets = workBook.sheet_names()获取所有的子表名
    #2- 获取需要操作的子表
    workSheet = workBook.sheet_by_name(sheetName)
    #3- 获取一列数据
    #print(workSheet.col_values(0))
    #4- 获取一行数据
    #print(workSheet.row_values(0))

    #获取单元格数据-workSheet.cell(行编号,列编号)
    # print(workSheet.cell(0,0).value)

    #--------v2.0新增功能--------------------
    #args---元组类型  ('URL'，‘标题’,'请求体')
    """
    需求分析：用户传入需要获取的列 ，代码去获取对应的列的单元格数据
    方案：
        1- 用户可以这样去调用函数  直接传递列编号 1,3,5,6---> args
            get_excel_data(excelDir,sheetName,caseName,1,3,5,6)
            感受：
                1-代码可读性差
                2- 你内部代码操作起来是方便的
        2- 用户可以这样去调用函数  直接传递-'URL'，‘标题’,'请求体'---> args
            get_excel_data(excelDir,sheetName,caseName,'URL'，‘标题’,'请求体')
            感受：
                1-代码可读性好，好理解业务需求
                2- 你内部代码操作起来是不方便： 需要把列名--转化为---列编号
    """
    colIndexList = []#存放用户输入列名对应的列编号
    # sheetName,caseName,*args,runCase=['all'],
    # print("sheetName",sheetName)
    # print("caseName",caseName)
    # print("args",args)
    # print("runCase",runCase)
    for i in args:# ('URL'，‘标题’,'请求体')遍历
        print("需要获取的args--->",i,workSheet.row_values(0).index(i))
        colIndexList.append(workSheet.row_values(0).index(i))#获取编号
    print(colIndexList)
    #--------------------------------------

    #-----用例筛选-------------------------
    #runCase = ['all','003','007-009','010']
    runList = []#运行用例编号列表 ['Login001','Login002']
    if 'all' in runCase:
        runList = workSheet.col_values(0)#全部选择
    else:#筛选
        for one in runCase:
            if '-' in one:# 连续  '001-003'--> ['name001','name002','name003']
                start,end = one.split('-') #001 ,003----字符串类型 -闭区间
                for i in range(int(start),int(end)+1):
                    runList.append(caseName+f'{i:0>3}')

            else:# 不连续  6，9
                runList.append(caseName+f'{one:0>3}')




    #--------------------------------------

    #--------获取对应的需求的数据-----------
    rowIndex = 0#行编号的初始值
    for one in workSheet.col_values(0):
        if caseName in one and one in runList:#筛选下
            #遍历那个列编号--列表
            getColData = []
            for num in colIndexList: #[4,5]
                tmp = workSheet.cell(rowIndex, num).value
                print("tmp",tmp,type(tmp))
                if is_json(tmp): #判断是否是json
                    tmp = json.loads(tmp)#
                getColData.append(tmp)
            resList.append(list(getColData))#[(请求1，响应1),(请求2，响应2)]
        rowIndex += 1#行编号 加1  下一行操作

    return resList
    # for one in resList:
    #     print(one)
    #----------------------------------------
"""
版本：v3.0
测试反馈：
    1- 业务登录接口需要是请求体数据是 字典格式，但是 get_excel_data返回的是字符串---需要转化  json.loads()
    2- 其他的数据（URL  标题）本身就是字符串，不需要转化
优化建议：
    1- 加判断是否json格式

"""
import json
def is_json(inData:str):
    try:
        json.loads(inData)
        return True#是json格式
    except:
        return False#不是json格式




if __name__ == '__main__':
    # def get_excel_data(sheetName,caseName,*args,runCase=['all'],excelDir=None):
    # fileDir = os.path.join(testData_path,'alist_System_V1.5.xls')
    # res=get_excel_data('登录模块','Login','标题','请求参数',runCase=['all'])
    # res=get_excel_data('登录模块','Login','标题','请求参数','响应预期结果',runCase=['1-3'])
    res=get_excel_data('存储管理','storage','标题','请求参数','响应预期结果',runCase=['all'])
    print(res)
