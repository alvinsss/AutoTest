# -*- coding: utf-8 -*-
# @Time    : 2023/2/9 16:10
# @Author  : alvin
# @File    : handle_yaml.py
# @Software: PyCharm
#安装yaml ：pip  install pyyaml

import yaml

def get_yaml_data(path):
                # 默认 read模式
    with open (path,encoding='utf-8') as f:
        return yaml.safe_load(f.read())

if __name__ == '__main__':
    res = get_yaml_data( "../configs/apiConfig.yaml" )
    print(res)