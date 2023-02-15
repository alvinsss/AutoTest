# -*- coding: utf-8 -*-
# @Time    : 2023/2/15 9:25
# @Author  : alvin
# @File    : handle_path.py
# @Software: PyCharm

import os
#定义全局基础项目目录
project_path = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
print(project_path)
# 谷歌浏览器版本110对应驱动
dirver_path = os.path.join(project_path,"extends","chromedriver.exe")
#日志
log_path = os.path.join(project_path,"logs")
#配置文件
config_path = os.path.join(project_path,"config")
#报告
report_path = os.path.join(project_path,"config")
#测试数据
data_path = os.path.join(project_path,"data")
#测试用例
testcase = os.path.join(project_path,"testcase")

