# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 15:47
# @Author  : alvin
# @File    : baseRequest.py
# @Software: PyCharm
import inspect

import requests
from utils.handle_yaml import get_yaml_data
from configs.config import HOST

class BaseRequest:
    def __init__(self,token=None):
        if token:
            self.header={'Authorization':token}
        else:
            self.header={'Content-Type' : 'application/json;charset=UTF-8'}
        # {'Login': {'login': None, 'url': '/account/sLogin', 'method': 'POST'}}
        # 通过类名作为键'Login'获取需要的部分数据
        self.data = get_yaml_data("../data/apiConfig.yaml")[self.__class__.__name__]
        print("self.data",self.data)

    def request_send(self,inData):
        try:
            # 获取调用本函数的调用方函数名
            funcName = inspect.stack()[1][3]
            print("调用我的函数名--->",funcName)
            data = self.data[funcName]
            print(f'{HOST}'+data['path'],data['method'],inData,self.header)
            resp=requests.request(url=f'{HOST}'+data['path'],method=data['method'],json=inData,headers=self.header)
            # resp=requests.request(url=f'{HOST}'+data['path'],method=data['method'],params=inData,headers=self.header)
            return resp.json()

        except Exception as error:
            raise 'except {}'.format(error)