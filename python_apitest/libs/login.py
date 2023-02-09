# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 11:02
# @Author  : alvin
# @File    : docs.py
# @Software: PyCharm


import requests
import hashlib
import copy
from common.baseRequest import BaseRequest
from configs.config import NAME_PSW


class Login(BaseRequest):
    def login(self,inData,getToken=False):#登录接口需要做自动化测试 需要执行用例
        #1- url == http://ip:port/路径
        #2- body----name psw  {name:xxxx,psw:xxx}
        inData = copy.copy(inData)# 使用浅拷贝，避免全局变量被修改掉！
        # 对密码加密  字典['键名'] = 新的值
        # inData['password'] = get_md5_data(inData['password'])
        # print("get_md5_data password",inData['password'] )
        payload = inData#请求体-----方便对密码进行操作
        print("payload",payload)
        #3- 发请求   requests.post(url,)
        resp = self.request_send(payload)
        #4- 打印下接口响应对不对！
        # print(resp.headers)#响应头
        # return resp.text#响应数据--字符串类型
        if getToken:
            print(resp['data']['token'])
            return resp['data']['token']
        else:
            print("resp",resp)
            return resp

def get_md5_data(psw:str):
    """
    :param psw: 加密前的密码
    :return: 加密后的密码
    """
    #1- 创建md5实例
    md5 = hashlib.md5()
    #2- 调用加密方法
    md5.update(psw.encode('utf-8'))
    return md5.hexdigest()#加密后的结果



if __name__ == '__main__':#ctrl+j
    print(NAME_PSW)#TODO 下次课我们讲代码的一些技巧 ----2021-11-11
    res = Login().login(NAME_PSW,True)




"""
md5加盐---salt值
原理：
注册时候：
    1- 用户输入密码 123456
    2- 123456+随机数/时间戳/固定字符
    3- MD5加密
    4- 项目后端它约定好，你使用加的是什么盐
    
RSA 加密  公私钥
#公钥加密，私钥解码，私钥签名，公钥验签
"""