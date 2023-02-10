# -*- coding: utf-8 -*-
# @Time    : 2023/2/7 18:45
# @Author  : alvin
# @File    : with和as.py
# @Software: PyCharm
"""
with 代码 as 变量
这里with执行语句如果不出错 就会赋值as后面的变量
用于文件读取 with快完毕后 自动关闭文件
"""
with open ("./try和except2.py" ,"r", encoding="utf-8") as f:
    print(f.read())