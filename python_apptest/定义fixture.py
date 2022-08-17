# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 11:19
# @Author  : alvin
# @File    : 定义fixture.py
# @Software: PyCharm
import  pytest

#定义
@pytest.fixture()
def setup_teardown():
    print("===我是测试用例的前置===")
    #yield 上面前置 后面后置
    yield
    print("===我是测试用例的后置===")

@pytest.fixture(scope="class")
def class_scope():
    pass

