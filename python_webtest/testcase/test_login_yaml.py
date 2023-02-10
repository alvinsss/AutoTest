# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 10:26
# @Author  : alvin
# @File    : test_login.py
# @Software: PyCharm
import pytest
from python_webtest.data_driver import  yaml_driver
@pytest.mark.parametrize('data',yaml_driver.load_yaml('../data/user.yaml'))
def test_login(data):
    print("---------------")
    print(data)

if __name__ == '__main__':
    pytest.main(['-s'])