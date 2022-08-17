# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 8:46
# @Author  : alvin
# @File    : test_add.py
# @Software: PyCharm
from add import add
import pytest

@pytest.mark.usefixture("setup_teardown")
def test_hello():
    assert True
#表示类下面的没个测试用例都会执行setup_teardown
@pytest.mark.usefixture("setup_teardown")
class TestAdd:

    def test_add(self):
        sum = add(1,2,3)
        assert sum == 6

    def test_add_ramdom(self):
        sum = add(12.3,2.7,1)
        assert sum == 16