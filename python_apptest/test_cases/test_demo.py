# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 9:07
# @Author  : alvin
# @File    : test_demo.py
# @Software: PyCharm

from python_apptest.test_cases.add import add

def test_add_four():
    assert  10== add(1,2,3,4)