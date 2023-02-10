#-*- coding: utf-8 -*-
#@File    : test_login.py
#@Time    : 2021/11/14 9:25
#@Author  : xintian
#@Email   : 1730588479@qq.com
#@Software: PyCharm
#Date:2021/11/14
import time

import pytest,allure
from libs.login import  Login
from utils.handle_excel import get_excel_data
from utils.handle_path import allure_json_path,allure_report_path
from common.baseRequest import RequestAssert
import os
"""
测试文件执行条件：
    1- 该业务层代码封装ok
    2- 需要自动化测试用例----数据驱动-使用指定文件类型做
        功能用例：人去执行
            1- excel
            2- word
            3- xmind
            4- yaml
            5- 数据库
        自动化用例选型：靠代码或者工具
            1- excel
            2- yaml
"""

@allure.epic('alist项目')
@allure.feature('登录模块')
class TestLogin(RequestAssert):
    @pytest.mark.parametrize('title,inBody,expData',
    get_excel_data('登录模块','Login','标题','请求参数','响应预期结果',runCase=['1-3']) )
    @allure.title("{title}")
    def test_login(self,title,inBody,expData):
        res = Login().login(inBody)
        print("res -->",res,type(res))
        print("expData -->",expData,type(expData))
    #断言:1-局部关键信息相等  2- 包含关系 in
        self.define_api_assert(res['code'],'=',expData['code'])

# SHIFT+tab  往前缩进 ，tab  往后缩进
if __name__ == '__main__':
    #输出 打印信息 -s
    #--clean-alluredir   清空json上一次运行的数据文件 allure serve ./outFiles/report/tmp
    pytest.main(['test_login.py','-s','--alluredir',allure_json_path,'--clean-alluredir'])
    # os.system('allure generate {} -o {}'.format(allure_json_path,allure_report_path))
    # os.system('allure serve {}'.format(allure_json_path))


"""
常见问题：在浏览器里出现allure页面显示 NO data
allure工作原理：
    1- 特性：allure是一个java应用---跨平台--Linux mac  win----
    2- 工作原理：
        1- allure是显示数据---就相当于显示屏
        2- 需要pytest 运行自动化测试用例 生成 json文件----具体的生成路径 alluredir = 存放json文件的路径
        3- allure  serve  存放json文件的路径
        4- 本机执行机器设置火狐为默认浏览器
"""