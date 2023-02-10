# -*- coding: utf-8 -*-
# @Time    : 2023/2/8 9:41
# @Author  : alvin
# @File    : conftest.py
# @Software: 用于前期数据准备
import pytest

#预置函数
@pytest.fixture
def alvin():
    print('author is alvin')

@pytest.fixture
def initenv():
    print("init env --- sql")

@pytest.fixture
def get_token():
    print("token is alvin")
    return 'alvin'