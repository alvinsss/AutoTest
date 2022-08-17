# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 8:46
# @Author  : alvin
# @File    : add.py
# @Software: PyCharm

def add(*args):
    sum = 0
    if args:
        for item in args:
            sum = sum + item
        return  sum
