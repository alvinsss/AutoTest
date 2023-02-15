# -*- coding: utf-8 -*-
# @Time    : 2023/2/10 10:53
# @Author  : alvin
# @File    : user.py
# @Software: PyCharm
from python_apitest.common.baseRequest import BaseRequest
from python_apitest.utils.handle_excel import get_excel_data
from python_apitest.libs.login import Login
from python_apitest.configs.config import NAME_PSW
import allure,pytest

class User(BaseRequest):
    pass

if __name__ == '__main__':
    token  = Login().login(NAME_PSW,getToken=True)
    print("token",token)
    # testData_create={"id": 0, "username": "test1", "password": "123456", "base_path": "",
    #           "role": 0, "permission": 0}
    # add_user= User(token).create(testData_create)
    # print(add_user)
    testData={}
    res = User(token).query(testData)
    print(res)
    # testData2={"id":"3"}
    # res_one = User(token).get_one(testData)
    # print(res_one)