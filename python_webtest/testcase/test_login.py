# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 10:26
# @Author  : alvin
# @File    : test_login.py
# @Software: PyCharm
import pytest
#                          名称            ， 值
@pytest.mark.parametrize(['user','passwd'],[('admin','123456'),('admin1','234567')])
def test_login(user,passwd):
    print(user,passwd)

#最基本的用法
@pytest.mark.parametrize("args", ['百里', '星瑶'])
def test_01_api(args):
    """
    获得网易新闻的接口
        :return:
        """
    print(args)

if __name__ == '__main__':
    pytest.main(['-s'])