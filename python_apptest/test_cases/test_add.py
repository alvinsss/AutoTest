# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 8:46
# @Author  : alvin
# @File    : test_add.py
# @Software: PyCharm
from python_apptest.test_cases.add import add
import pytest
from python_apptest.my_logger import logger

@pytest.mark.usefixture("setup_teardown")
def test_hello():
    assert True
#表示类下面的没个测试用例都会执行class_scope ,setup_teardown
@pytest.mark.smoke
@pytest.mark.usefixture("class_scope")
@pytest.mark.usefixture("setup_teardown")
class TestAdd:

    def test_add(self):
        sum = add(1,2,3)
        assert sum == 6

    def test_add_ramdom(self):
        sum = add(12.3,2.7,1)
        assert sum == 16