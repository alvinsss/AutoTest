# -*- coding: utf-8 -*-
# @Time    : 2023/2/7 17:57
# @Author  : alvin
# @File    : try和except.py
# @Software: PyCharm
"""
程序执行报错 字符串相加，除以0，字符串切片越界
"""
s= "hello py"
try:
    print(s[22])
except Exception:
    print("...")

