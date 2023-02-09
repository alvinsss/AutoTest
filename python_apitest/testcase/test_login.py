# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 18:38
# @Author  : alvin
# @File    : test_login.py
# @Software: PyCharm
import pytest,allure
from libs.login import Login
from utils.handle_yaml import get_yaml_data
class TestLogin(object):

    @pytest.mark.parametrize('inBody','expData',get_yaml_data("../data/apiConfig.yaml"))
    def test_login(self,inBody,expData):
        #1、调用业务曾封装的接口代码
        #2、断言时间返回与预期结果
        pass
