# -*- coding: utf-8 -*-
# @Time    : 2023/2/13 8:51
# @Author  : alvin
# @File    : handlelog.py
# @Software: PyCharm
import datetime
import os.path
import logging

from python_apitest.utils.handle_inifile import get_inifile
from python_apitest.utils.handle_path import log_path, config_path


def logger(flag=True,name=__name__):

    #项目名称
    path = os.path.join(config_path,"loguru.ini")
    pname=get_inifile(path,'log',inkey='pname')
    #log 文件名，路径+｛时间｝.log
    logDir= os.path.join(log_path,("{}_{}.log".format(pname,datetime.datetime.now().strftime('%Y%m%d_%H%M'))))
    #1\创建日志对象
    logObject = logging.getLogger(name)
    #2\设置级别
    logObject.setLevel(logging.INFO)
    #3设置日志内容格式
    fmt = '%(asctime)s - %(levelname)s - %(filename)s[%(lineno)d]:%(message)s'
    format = logging.Formatter(fmt)

    #看输入文件还上控制台
    if flag:
        #设置日志渠道-文件方式
        handle = logging.FileHandler(logDir,encoding='utf-8')
        #日志内容渠道绑定
        handle.setFormatter(format)
        #日志对象跟渠道绑定
        logObject.addHandler(handle)
    else:
        #设置日志渠道-控制台方式
        handle = logging.StreamHandler()
        #日志内容渠道绑定
        handle.setFormatter(format)
        #日志对象跟渠道绑定
        logObject.addHandler(handle)

    return logObject

#单例模式，对象有，不重复创建
log = logger()

if __name__ == '__main__':
    # print(os.path.join(log_path,("{}.log".format(datetime.datetime.now().strftime('%Y%m%d%H%M')))))
    log.info("qatest")

