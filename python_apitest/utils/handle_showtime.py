# -*- coding: utf-8 -*-
# @Time    : 2023/2/11 20:30
# @Author  : alvin
# @File    : handle_showtime.py
# @Software: PyCharm
import time

def showtime(func):
    def inner(*args):
        start_t= time.time()
        res = func(*args)
        end_t  = time.time()
        print("func:{} exec time is:{} ".format(func,(end_t-start_t)))
        return res
    return inner