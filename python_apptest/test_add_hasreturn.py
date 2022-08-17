# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 8:46
# @Author  : alvin
# @File    : test_add.py
# @Software: PyCharm
from add import add
import pytest

def test_has_return(has_return):
    print("test_has_return",has_return)
    assert True

@pytest.mark.usefixture("has_return")
class TestAdd:

    def test_add_return(self,has_return):
        print("return",has_return)
        sum = add(1,2,3)
        assert sum == 6
