# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 15:01
# @Author  : alvin
# @File    : testhtml.py
# @Software: PyCharm
import os
import time
import pytest
import allure

@allure.story("用户的登录成功")
@allure.title("用户操作case")
def testhtml_login():
    print("testhtml_test1 api")
    assert  1 !=1

@allure.story("用户的失败")
@allure.title("用户操作case")
def testhtml_test4():
    print("testhtml_test4 api")
    assert  1 !=2
@pytest.mark.api
def testhtml_test2():
    print("testhtml_test2 api")
    assert  1 !=2

@pytest.mark.api
@allure.feature("处理bug回归")
def testhtml_test3():
    print("testhtml_test3 api")
    assert  2 == 2


if __name__ == '__main__':

    pytest.main(['-s' ,__file__, '--alluredir', './report_allure/'])
    #