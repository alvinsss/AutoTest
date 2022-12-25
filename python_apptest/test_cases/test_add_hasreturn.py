# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 8:46
# @Author  : alvin
# @File    : test_add.py
# @Software: PyCharm
from python_apptest.test_cases.add import add
import pytest
from python_apptest.my_logger import logger

def test_has_return(has_return):
    print("test_has_return",has_return)
    assert True

@pytest.mark.usefixture("has_return")
class TestAdd:

    def test_add_return(self,has_return):
        logger.info("has_return返回值:{}".format(has_return))
        logger.info("测试数据为:{}".format(*has_return))
        sum = add(*has_return)
        logger.info("实际结果:{}".format(sum))
        assert sum == 300
        logger.info("期望结果:{}".format(300))
