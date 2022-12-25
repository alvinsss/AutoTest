# -*- coding: utf-8 -*-
# @Time    : 2022/8/18 14:32
# @Author  : alvin
# @File    : customerlogging.py
# @Software: PyCharm
import logging
# 继承
class MyLogger(logging.Logger):

    def __init__(self,name,level="INFO",file=None):
        #父类的__init__
        super().__init__(name,level="INFO")
        #设置自己的逻辑
        fmt = "%(asctime)s-%(name)s:%(levelname)s:%(filename)s-【%(lineno)d】: %(message)s"
        ft = logging.Formatter(fmt)
        # 5、设置输出渠道的格式
        handle2=logging.StreamHandler()
        handle2.setFormatter(ft)
        self.addHandler(handle2)
        if file:
            handle1=logging.FileHandler(file,encoding='utf-8')
            handle1.setFormatter(ft)
            self.addHandler(handle1)

logger=MyLogger("app-autotest",file='E:\eclipse-workspace\AutoTest\python_apptest\log\logdata.log')
