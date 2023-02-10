# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 14:09
# @Author  : alvin
# @File    : test_case_mark.py
# @Software: PyCharm
import pytest

@pytest.mark.webui
def test_01():
    print("test01...")
@pytest.mark.api
def test_02():
    print("test02...")
@pytest.mark.webui
def test_03():
    print("test03...")
@pytest.mark.webui
@pytest.mark.api
def test_04():
    print("test04...")
@pytest.mark.api
def vip_05():
    print("vip...")
if __name__ == '__main__':
    pytest.main(['-s', 'test_case_mark.py'])