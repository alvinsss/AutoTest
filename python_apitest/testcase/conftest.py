# -*- coding: utf-8 -*-
# @Time    : 2023/2/10 12:49
# @Author  : alvin
# @File    : conftest.py
# @Software: PyCharm
import pytest
from python_apitest.libs.login import Login
from python_apitest.configs.config import NAME_PSW
from python_apitest.libs.user import User
from python_apitest.libs.storage import Storage
"""
作用：环境初始化和返回被测试接口实例，方便testcase层直接使用
，使用conftest.py进行结合pytest.fixture进行测试环境及变量初始化操作
"""
#没有返回值的fixture
@pytest.fixture(scope='session',autouse=True)
def start_running():
    #---自动化测试前的--环境操作
    print('---Alist项目自动化测试开始执行---')
    yield #-yeild后面没有值就是没有返回值
    print('Alist项目自动化测试执行完成，数据清除完成')

@pytest.fixture(scope='class')
def notreturn():#没有yeild或者return  也是没有返回值
    print('没有返回值的fixture')

#--------登录操作-----------
#其他的业务层测试代码需要调用这个登录
#返回值的fixture---直接使用这个函数名--就是代表返回值 -login_init == token
@pytest.fixture(scope='session')
def login_init():
    print('---用户操作登录---')
    token = Login().login(NAME_PSW,getToken=True)
    print("token",token)
    yield token#返回token---有返回值
    print('---登录完成---')#或者可以执行退出操作
    #return token#后面就不能写代码

#--------用户管理，为了返回用户实例-----------
#如果一个fixture需要使用另外一个fixture的返回值，直接使用fixture即可
@pytest.fixture(scope='class')
def user_init(login_init):
    print('---用户管理实例创建开始---')
    userObject = User(login_init)
    yield userObject#返回值返回用户实例
    print('---用户管理实例创建完成---')

@pytest.fixture(scope='class')
def storage_init(login_init):
    print('---Storage管理实例创建开始---')
    storageObject = Storage(login_init)
    yield storageObject#返回值返回Storage实例
    print('---Storage管理实例创建完成---')