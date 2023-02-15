# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 16:10
# @Author  : alvin
# @File    : handle_yaml.py
# @Software: PyCharm
#安装yaml ：pip  install pyyaml
import os

import yaml
from python_apitest.utils.handle_path import  config_path

def get_yaml_data(path):
    # 默认 read模式
    with open (path,encoding='utf-8') as f:
        return yaml.safe_load(f.read())
        #写yaml文件
def set_yaml_data(path,data):
    with open(path,'a',encoding='utf-8') as f:
        yaml.safe_dump(data,f)

        #写分段yaml文件,写入文件包含 ---
def set_yamls_data(path,data):
    with open(path,'w',encoding='utf-8') as f:
        yaml.safe_dump_all(data,f)

#处理yaml组装成[[],[]]多组数据与xls方法返回一致格式
def get_yaml_casedata(path):
    resList=[]
    with open (path,'r',encoding='utf-8') as f:
        res= yaml.safe_load(f.read())
        for i in res:
            resList.append([i['detail'],i['data'],i["resp"]])
        return resList

if __name__ == '__main__':
    # datas=[[10,20,30],{"name":"alvin"}]
    # set_yamls_data( '../data/testcase.yaml', datas )
    res = get_yaml_casedata('../data/testcase_user.yaml')
    print(res)