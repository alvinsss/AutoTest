# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 8:46
# @Author  : alvin
# @File    : test_add.py
# @Software: PyCharm
from add import add

class TestAdd:

    def test_add(self):
        sum = add(1,2,3)
        assert sum == 6

    def test_add_ramdom(self):
        sum = add(12.3,2.7,1)
        assert sum == 16