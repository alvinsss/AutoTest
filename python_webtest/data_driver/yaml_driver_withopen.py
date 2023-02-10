# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 11:47
# @Author  : alvin
# @File    : yaml_driver_withopen.py
# @Software: PyCharm

import yaml
def read_yaml(path):
    """
    读取yaml,对yaml文件反序列化，就是我们的yaml格式转换成字典的格式
    :return:
    """
    with open(path, encoding='UTF-8')as f:
        data = yaml.load(f, Loader=yaml.FullLoader)
        return data