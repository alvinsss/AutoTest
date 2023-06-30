# -*- coding: utf-8 -*-
# @Time    : 2023/2/14 15:10
# @Author  : alvin
# @File    : handle_path.py
# @Software: PyCharm
import os
"""
需求：代码在任意路径都可以获取到项目工程的绝对路径
"""
# print(__file__)#当前文件所在的路径
# print(os.path.dirname(__file__))
# print(os.path.dirname(os.path.dirname(__file__)))
#1- 工程路径
project_path = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
print("project_path",project_path)

#2- 配置路径
config_path = os.path.join(project_path,'configs')
print("config_path",config_path)

#3- 测试数据路径
testData_path = os.path.join(project_path,'data')


#3- 测试数据路径
qatestData_path = os.path.join(project_path,'testdata')
print(qatestData_path)

#4- 测试报告路径
allure_json_path = os.path.join(project_path,r'report\allure_json')
allure_report_path = os.path.join(project_path,r'report\allure')
allure_result_path = os.path.join(project_path,'report','result')
# print("allure_json_path:",allure_json_path)
# print("allure_report_path:",allure_report_path)


#5- log路径
log_path = os.path.join(project_path,r'logs')
#print(log_path)