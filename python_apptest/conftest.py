# -*- coding: utf-8 -*-
# @Time    : 2022/8/17 11:50
# @Author  : alvin
# @File    : conftest.py
# @Software: PyCharm
#支持共享。 -- conftest.py 不需要引入，主动调用。

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
    print("===我是类级别测试用例的前置===")
    yield
    print("===我是类级别测试用例的后置===")

@pytest.fixture(scope="class")
def class_scope():
    pass

#定义带返回值 元祖
@pytest.fixture()
def has_return():
    print("===我是测试用例的前置===")
    yield 100,200
    print("===我是测试用例的后置===")