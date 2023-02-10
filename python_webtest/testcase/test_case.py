# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 9:16
# @Author  : alvin
# @File    : test_case.py
# @Software: PyCharm
import pytest
from python_webtest.config.conftest import get_token,initenv

def test_qa01(get_token):
    print("test01...")
    print(get_token)
    assert get_token ==  "alvin",'token is error'
def test_02(initenv):
    print("test02...")
def teardown_function():
    print("teardown_function")
def setup_function():
    print("setup_function")
def teardown_module():
    print("teardown_module")
def setup_module():
    print("setup_module")
class TestDemo(object):
    def test_d1(self):
        print("test1")
    def test_d2(self):
        print("test1")
    def setup(self):
        print("setup")
    def teardown(self):
        print("teardown")
    def setup_class(self):
        print("setup_class")
    def teardown_class(self):
        print("teardown_class")
    def setup_method(self):
        print("setup_method")
    def teardown_method(self):
        print("teardown_method")
if __name__ == '__main__':
    pytest.main(['-s', 'test_case.py'])