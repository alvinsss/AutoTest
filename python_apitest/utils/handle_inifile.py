# -*- coding: utf-8 -*-
# @Time    : 2023/2/14 13:09
# @Author  : alvin
# @File    : handle_inifile.py
# @Software: PyCharm  pip install configparser
import  configparser
import os
from python_apitest.utils.handle_path import config_path

#path 路径， insections 字段 ，inkey对应的key ，如果没入参返回list
def get_inifile(path,insections,inkey=None):
    conf =configparser.ConfigParser()
    conf.read(path)
    #获取所有区域
    datalist =[]
    sections = conf.sections()
    for section in sections:#字段
        if insections == section:
            for values in conf.items(insections): #元祖，内容
                # print("inkey",inkey)
                # print(values[0],values[1],inkey in values[0])
                if inkey != None and inkey in values[0]:
                    # keydata={values[0]:values[1]}
                    return values[1]
                else:
                    # datadict={values[0]:values[1]}
                    datalist.append({values[0]:values[1]})
    # data = conf.get('log','format')
    # print(datalist)
    return datalist

if __name__ == '__main__':
    path = os.path.join(config_path,"loguru.ini")
    # res1 = get_inifile(path,'log')
    # print(res1,type(res1))
    # for i in res1:
    #     if  'rotation' in i.keys():
    #         print(i['rotation'])
    res = get_inifile(path,'log',inkey='pname')
    print(res )