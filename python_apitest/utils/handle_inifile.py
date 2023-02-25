# -*- coding: utf-8 -*-
# @Time    : 2023/2/14 13:09
# @Author  : alvin
# @File    : handle_inifile.py
# @Software: PyCharm  pip install configparser
import  configparser
import os
from python_apitest.utils.handle_path import config_path



def get_sendmail_info():
    path = os.path.join(config_path,"config.ini")
    contents="mail"
    tmpdict = {}
    config = configparser.ConfigParser()
    config.read( path)
    send_user = config.get( contents, 'SEND_USER' )
    login_pwd = config.get( contents, 'SEND_USER_PASSWD' )
    from_addr = config.get( contents, 'FROM_ADDRS' )
    to_addrs = config.get( contents, 'TO_ADDRS' )
    host = config.get( contents, 'HOST' )
    port = config.get( contents, 'PORT' )
    tmpdict['login_user'] = send_user
    tmpdict['login_pwd'] = login_pwd
    tmpdict['from_addr'] = from_addr
    tmpdict['to_addrs'] = to_addrs
    tmpdict['host'] = host
    tmpdict['port'] = port
    return tmpdict

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
                    inkey=inkey.lower() #ini都是小写
                    # keydata={values[0]:values[1]}
                    return values[1]
                else:
                    # datadict={values[0]:values[1]}
                    datalist.append({values[0]:values[1]})
    # data = conf.get('log','format')
    # print(datalist)
    return datalist

if __name__ == '__main__':
    path = os.path.join(config_path,"config.ini")
    # res1 = get_inifile(path,'log')
    # print(res1,type(res1))
    # for i in res1:
    #     if  'rotation' in i.keys():
    #         print(i['rotation'])
    # res = get_inifile(path,'mail')
    # print(res,type(res) )
    mail=get_sendmail_info()
    print(mail)