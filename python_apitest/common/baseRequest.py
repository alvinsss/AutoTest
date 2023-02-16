# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 15:47
# @Author  : alvin
# @File    : baseRequest.py
# @Software: PyCharm
print()
import requests
"""
没有封装的接口代码：每一个自动化测试方法都需要加异常机制+log
基类的封装思路：
    1- 加入异常机制+log
    2- 截图操作---ui 自动化
    3- 一般模块的常用接口：
        增删改查 
    4- 代码不太可能一次性写的完整！
def request(method, url, **kwargs)
#
method, url
接口风格：
    1- 常规风格：
        1、一个模块，增删改查的4个接口的路径的不一样--自定义性比较强
        2、请求和响应数据类型不定
    2- restful风格
        1、一个模块，增删改查的4个接口的路径的一样的
        2、请求和响应数据类型一样的--json格式

一个项目的版本定下来之后：
    一个接口有10个用例：
        1- 变的是： 接口的描述、接口的用例请求参数、预期的响应
        2- 不变的是: url  请求方法
"""
from python_apitest.utils.handle_yaml import get_yaml_data
from python_apitest.configs.config import HOST
from python_apitest.utils.handle_path import config_path
from python_apitest.utils.handle_log import log #函数对象
import traceback
import inspect,json
import os

class BaseRequest:#基类
    def __init__(self,inToken=None):#初始化方法
        if inToken:# 业务接口 传递了token---inToken=有值
            self.headers = {'Authorization':inToken}
        else:# 登录接口不需要token传入的
            # self.headers = None
            self.headers = {'Content-Type':'application/json;charset=UTF-8'}
    #通过模块名去获取对应模块的数据
        self.data = get_yaml_data(os.path.join(config_path,"apiConfig.yaml"))[self.__class__.__name__]
        print("继承基类名称是 --------- : ",self.__class__.__name__)
        log.info("继承基类名称是 --------- :{} ".format(self.__class__.__name__))

    #--------公共的发送方法----------每一个接口方法都会调用这个去发送请求
    def request_send(self,data=None,file=None):
        try:
            methodName = inspect.stack()[1][3]#谁调用了我，他的函数名
            print("request_send methodname --------- : ",methodName)
            print("request_send data      -----------: ",self.data[methodName])
            log.info("request_send methodname --------- :{} ".format(methodName))
            log.info("request_send data --------- :{} ".format(self.data[methodName]))
            path,method = self.data[methodName].values()#apiConfig.yaml配置的methodName名称
            # 数据---需要剥离对应某一个接口的数据
            print("request_send info --------->",f'{HOST}{path}',method,self.headers,data,type(data))
            log.info("request_send info --------->path:{},method:{},header:{},data:{}".format(path,method,self.headers,data))
            if file:
                resp = requests.request(method=method,url= f'{HOST}{path}',files=data,headers=self.headers)
            else:
                resp = requests.request(method=method,url= f'{HOST}{path}',json=data,headers=self.headers)
                print(" resp -------->:",resp.json())
                log.info("resp info --------->{}".format(resp.json()))
        # resp = requests.request(method=method,url= f'{HOST}{path}',data=data)
            #print(methodName,'---',self.data[methodName])
            return resp.json()
        except:
            #打日志
            pass

    #1- 新增接口：
    def create(self,data):
        return self.request_send(data=data)

    #2- 删除接口---对应某一个id  删除  /delete/api/{id}
    def delete(self,data):
        return self.request_send(data=data)
    #3- 更新接口
    def update(self,data):
        return self.request_send(data=data)
    #4- 查询list接口
    def query(self,data):
        return self.request_send(data=data)
    #5- 查询一个
    def get_one(self,data):
        return self.request_send(data=data)

class RequestAssert:
    @classmethod#类方法,不需要实例，直接类名. 方法名调用即可
    def define_api_assert(cls,result,condition,exp_result):
        print("result-->",result,type(result))
        print("exp_result-->",exp_result,type(exp_result))
        try:
            if condition == '=':
                assert result == exp_result
            elif condition == 'in':
                assert  exp_result in result
        except Exception as error:
            #日志 打印详情断言失败信息
            log.error("traceback info :",traceback.format_exc())
            raise error# 抛出异常---不影响pytest 运行结果！



#---------------------------扩展-------------
"""
inspect
 1- 可以获取类或函数的参数的信息
 2- 获取当前本函数的函数名
 3- 获取调用函数的函数名

"""
# import inspect,sys
# def a():
#     print('执行函数---a')
#     print('谁调用了我a，哪一个函数名>>> ',inspect.stack()[1][3])
#
# def b():
#     print('执行函数---b')
#     a()
#     #print('b函数---当前自己的函数名',sys._getframe().f_code.co_name)
#
# def c():
#     a()
#
#
#
# c()
