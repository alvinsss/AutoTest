# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 18:04
# @Author  : alvin
# @File    : login.py
# @Software: PyCharm
from common.baseRequest import BaseRequest
from utils.handle_data import get_md5_data
from configs.config import NAME_PSW
import copy

from utils.handle_showtime import showtime

"""
登录这个模块-登录接口使用场景：
    1- 本身的登录接口自动化测试
    2- 为后续接口获取token
"""
class Login(BaseRequest):
    @showtime
    def login(self,inData,getToken=False):
        inData = copy.copy(inData)#浅拷贝下数据--避免修改全局数据
        # inData['password'] = get_md5_data(inData['password'])
        respData = self.request_send(data=inData)#发送请求
        print("respData-->",respData,type(respData))
        if getToken: # 获取token
            return respData['data']['token']
        else:#获取响应数据
            return respData


if __name__ == '__main__':
    print(Login().login(NAME_PSW))