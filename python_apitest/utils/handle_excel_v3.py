# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 11:04
# @Author  : alvin
# @File    : handle_excel_v1.py
# @Software: PyCharm
'''
函数：get_excel_data()
版本： v3.0
函数功能：1.获取请求的body 与预期响应结果
        2.可以自定义获取对应的列数据
        3.需要获取测试用例指定的用例运行
具体：用例筛选
    1-全部执行 all
    2-分段执行 tc001-tc004
    3-随机执行某一个tc001  tc008
    4-混合模式：['tc001','tc003-tc007','tc009']
pytest只能定制化执行接口层 --跑某一个接口或不跑某一个接口
但是 具体的测试用例挑选框架做不了，是靠一个数据驱动装饰器执行 pytest.makr.paramtrize(挑选出来)
'''
import xlrd
#必填  可变  可全缺省
def get_excel_data(excelDir,sheetName,caseName=None,*colName,selectCase=['all']):
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

    '''
        挑选用例,all全部，['1','3-7']单个，分段
    '''
    selectList =[] #挑选出来的用例
    if  'all' in selectCase:#全部执行这个接口的用例
        selectList = workSheet.col_values(0)
    else: #['1','3-7']
        for one in selectCase:
            if '-' in one:#是一段
                start,end = one.split('-') #3,7
                for i in range(int(start),int(end)+1): #(3,8)
                    selectList.append(caseName+f'{i:0>3}')#Login3-->Login003
            else:
                selectList.append(caseName+f'{one:0>3}')
    print("selectList",selectList)



    idx = 0 #行号初始
    for data in workSheet.col_values(0):
        # print("data",data)
        if caseName in data and data in selectList:
            # print(caseName)
            getColData = []#存放一行对应很多列数据
            for colIdx in colIndxList:
                res = workSheet.cell_value(idx,colIdx)#单元格数据
                getColData.append(res)
            resList.append(getColData)
        idx = idx +1
    return resList

if __name__ == '__main__':
    configData = ['用例编号','标题','URL','请求参数']
    res=get_excel_data('../data/alist_System_V1.5.xls','登录模块','Login',*configData,selectCase=['3-5'])
    print(res)
    for one in res:
        print(one)

