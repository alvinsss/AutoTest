# -*- coding: utf-8 -*-
# @Time    : 2023/2/10 19:41
# @Author  : alvin
# @File    : test_yanm.py
# @Software: PyCharm
# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 16:10
# @Author  : alvin
# @File    : handle_yaml.py
# @Software: PyCharm
#安装yaml ：pip  install pyyaml
import os

import yaml
from utils.handle_path import  config_path
def get_yaml_data(path):
    # 默认 read模式
    with open (path,encoding='utf-8') as f:
        return yaml.safe_load(f.read())

if __name__ == '__main__':
    res = get_yaml_data("./data.yaml" )
    print(res)