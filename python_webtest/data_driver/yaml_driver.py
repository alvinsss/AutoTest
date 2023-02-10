# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 10:41
# @Author  : alvin
# @File    : yaml_driver.py
# @Software: PyCharm
import  yaml

def load_yaml(path):
    file = open(path,"r",encoding='utf-8')
    data = yaml.load(file,Loader=yaml.FullLoader)
    return data

if __name__ == '__main__':
    print(load_yaml("../data/user.yaml"))