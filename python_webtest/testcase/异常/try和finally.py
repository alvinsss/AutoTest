# -*- coding: utf-8 -*-
# @Time    : 2023/2/7 18:25
# @Author  : alvin
# @File    : try和finally.py
# @Software: PyCharm

s="hello python!"
try:
    print(s[2])
except Exception:
    print("异常才执行")
finally:
    print("不管有没有异常 都会执行！")